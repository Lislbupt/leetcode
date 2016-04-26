package com.lisl.code;

class MinStack {
	int[] stack;
    int top_index = -1;
    int min = Integer.MAX_VALUE;
    //ArrayList<Integer> min_index = new ArrayList<Integer>();
    int[] min_index;
    int rear = -1;
    
    public MinStack(){
        this.stack = new int[100000];
        this.min_index = new int[100000];
    }
    
    public void push(int x) {
        stack[++top_index] = x;
        if(x<min){
        	min = x;
        	//min_index.add(top_index);
        	min_index[++rear] = top_index;
        }
    }

    public void pop() {
    	if(top_index==min_index[rear]){
    		rear--;
    		if(rear<0){
    			min = Integer.MAX_VALUE;
    		}else{
    			min = stack[min_index[rear]];
    		}
    	}
    	if(top_index>-1){
    		top_index--;
    	}
    }

    public int top() {
        return stack[top_index];
    }

    public int getMin() {
        return min;
    }
    
    public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(1);
		minStack.push(2);
		minStack.push(3);
		minStack.push(0);
		minStack.push(-1);
		minStack.push(2);
		
		
		minStack.pop();
		minStack.pop();
		minStack.pop();
		minStack.pop();
		minStack.pop();
		minStack.pop();
		minStack.push(2);
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}
