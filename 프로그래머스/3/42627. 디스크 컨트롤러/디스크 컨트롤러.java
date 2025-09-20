import java.util.*; 

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 요청 시간 순으로 정렬하는 jobList
        PriorityQueue<Job> jobList = new PriorityQueue<>((a, b) -> {
            if(a.requestTime == b.requestTime) {
                return a.requiredTime - b.requiredTime; 
            }
            else return a.requestTime - b.requestTime; 
        }); 
        // 소요 시간 순으로 정렬하는 doJobList
        PriorityQueue<Job> doJobList = new PriorityQueue<>(); 
        
        // 우선 요청 시간 순으로 전체 정렬한다 
        for(int i = 0; i < jobs.length; i++) {
            jobList.offer(new Job(i, jobs[i][0], jobs[i][1])); 
        }
        
        Job firstJob = jobList.poll(); 
        int time = firstJob.requestTime; 
        doJobList.offer(firstJob); 
        
        // 요청 시간이 time인 작업은 doJobList로 이동시킨다. 
        // doJobList에서 소요 시간이 짧은 작업부터 실행한다. 
        // 작업 시작 시간 + 소요 시간 이후에 doJob은 fale가 된다. 
        // false이면 새로운 작업을 시작한다. 
        while(true) {
            while(!jobList.isEmpty()) {
                Job tmp = jobList.poll(); 
                if(tmp.requestTime <= time) {
                    doJobList.offer(tmp); 
                } else if(doJobList.isEmpty()) {
                    doJobList.offer(tmp); 
                    time = tmp.requestTime; 
                }
                else {
                    jobList.offer(tmp); 
                    break;
                }
            }
            
            if(doJobList.isEmpty()) break; 
            Job doJob = doJobList.poll(); 
            answer += time + doJob.requiredTime - doJob.requestTime; 
            time += doJob.requiredTime; 
        }
        
        return (int)(answer / jobs.length); 
    }
}

class Job implements Comparable <Job> {
    int num; // 작업 번호 
    int requestTime; // 요청 시간 
    int requiredTime; // 소요 시간  
    
    Job(int num, int requestTime, int requiredTime) {
        this.num = num; 
        this.requestTime = requestTime; 
        this.requiredTime = requiredTime; 
    }
    
    @Override
    public int compareTo(Job o) {
        if(this.requiredTime == o.requiredTime) {
            if(this.requestTime == o.requestTime) {
                return this.num - o.num; 
            }
            return this.requestTime - o.requestTime; 
        }
        return this.requiredTime - o.requiredTime; 
    }
    
}