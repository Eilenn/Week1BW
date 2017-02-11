package com.capgemini.hanoi;

public class Stack {
	int[] stackOfRings;
	int stackTopIndex; //indeks ostatniego zajetego

	public Stack(){
		
	}
	
	public Stack(int numberOfRings) {
		stackOfRings = new int[numberOfRings];
		stackTopIndex = -1;
	}
	
    public int getMaximumStackSize() {
        return stackOfRings.length;
    }
    
    public int getSize() {
        return stackTopIndex;
    }
    
	// zdejmowanie ze stosu 
	public int pop() throws ArrayIndexOutOfBoundsException {
		if(stackTopIndex<0){
			throw new ArrayIndexOutOfBoundsException("Stack is empty, you cannot remove any elements");
		}
		else{
			
			return stackOfRings[stackTopIndex--];
		}
	}

	// dodawanie do stosu
	public void push(int ring) throws ArrayIndexOutOfBoundsException {
		// preincrement 
		if (stackTopIndex < stackOfRings.length) {
			stackOfRings[++stackTopIndex]=ring;
			
		}
		else{
			throw new ArrayIndexOutOfBoundsException("Stack is full, you cannot add any new elements");
		}
		
	}

	// wartosc wierzcholka stosu
	public int peek() {
		return stackOfRings[stackTopIndex];
	}

	public boolean isEmpty() {
		if (stackTopIndex==-1) {
			return true;
		}
		else
			return false;
	}

	public void display() {
		for (int i = 0; i <= stackTopIndex; i++) {
			System.out.print(stackOfRings[i]+" ");
		}
	}
	
	public void displayVertical() {
		for (int i = stackTopIndex; i >=0; i--) {
			System.out.println(stackOfRings[i]+" ");
		}
	}
}
