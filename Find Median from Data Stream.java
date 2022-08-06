class MedianFinder {
    
    PriorityQueue<Integer> min; 
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b)->b-a); 
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || max.peek()>num)
        {
            max.offer(num);
        }
        else{
            min.offer(num);
        }
        
        if(max.size()>min.size()+1)
        {
            min.offer(max.peek());
            max.poll();
        }
        else if(min.size()>max.size()+1)
        {
            max.offer(min.peek());
            min.poll();
        }
    }
    
    public double findMedian() {
        if(max.size()==min.size())
        {
            return (max.peek()+min.peek())/2.0;
        }
        else
        {
            if(max.size()>min.size())
            {
                return max.peek()+0.0;
            }
            else if(min.size()>max.size())
            {
                return min.peek()+0.0;
            }
        }
        
        return 0.0;
    }
}

