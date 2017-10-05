package project1;

public class List {
	
    private int size = -1; //keeps track of size and starts index at 0 for the first element
    private Link first; //head element
    
    public List() {
        first = null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void insertItem(String name) {
    		Link link = new Link(name);
        link.setLink(first);
        first = link;
        size++;
    }
    
    public void insertItem(String name, int pos) {
    		if (pos == 0) insertItem(name);
    		else {
    			Link add = new Link(name); //new link to be inserted
        		Link current = first; //current link - temporary
        		for(int i=0; i<pos; i++) {
        			current = current.getLink();
        		}
        		add.setLink(current);
        		current.setLink(add);
        		current = current.getLink();
        		
        		size++;
    		}
    }
    
    public Link find(String name) {
    		if (isEmpty()) throw new StackUnderflowException("The list is empty.");
		
		if (first.getInfo().equals(name)) return first;
		
		Link iterator = first;
		while (iterator != null) {
			iterator.getLink();
			if (iterator.getInfo().equals(name)) return iterator;
			
		}
		
		return null;
    }
    public Link findNodeBefore(String name) {
		if (isEmpty()) throw new StackUnderflowException("The list is empty.");
	
		if (first.getInfo().equals(name)) return first;
		
		Link iterator = first;
		while (iterator != null) {
			if (iterator.getLink().getInfo().equals(name)) return iterator;
			iterator.getLink();
		}
		
		return null;
	}
    
    public boolean removeItem(String name) {
    		if (isEmpty()) throw new StackUnderflowException("The list is empty.");
    		if (first.getInfo().equals(name)) { //if element is first in the list
    			first = first.getLink();
    			return true;
    		}
    		else {
    			Link current = first;
    			while (current != null) {
    				if (current.getLink().getInfo().equals(name)) {
    					current.setLink(current.getLink().getLink());
    					return true;
    				}
    			}
    		}
    		return false;
    }
    
    public void removeItem(int position) {
    		if (isEmpty()) throw new StackUnderflowException("The list is empty.");
    		else {
    			if (size < 0 || size <= position) {
    				throw new IndexOutOfBoundsException("index = " + position);
    			}
    			Link current = first; //current link - temporary
    			for (int i = 0; i<position-1; i++) {
    				current = current.getLink();
    			}
    			current.setLink(current.getLink().getLink());
    			size--;
    		}
    }
    
    public boolean contains(String name) throws StackUnderflowException {
    		if (isEmpty()) throw new StackUnderflowException("The list is empty.");
    		else {
	    		Link current = first;
	    		while(current.getLink() != null) {
	    			if (current.getInfo() == name) return true;
	    		}
	    		return false;
    		}
    }
    
    public void clear() {
    		first = null;
    		size = -1;
    }
    
    public String get(int index) {
  	  Link current = first;
  	  for (int i = 0; i < index; i++) {
  		  current = current.getLink();    
  	  }
  	  return current.getInfo();
    }
    
    public int size() {
        return size;
    }
    
    public String toHTMLString() {   
	  String result = "<html>PlayList<br/>";
	  Link current = first;
	  while(current.getLink() != null) {
		  result += current.getInfo() + "<br/>";
		  current = current.getLink();
	  }
	  result += "</html>";
	  return ("List: " + result);
    }
    
    @Override
    public String toString() {
  	  String result = "";
  	  Link current = first;
  	  while(current.getLink() != null) {
  		  result = result + current.getInfo() + "\n";
  		  current = current.getLink();
  	  }
  	  return result;
    }
    
}
