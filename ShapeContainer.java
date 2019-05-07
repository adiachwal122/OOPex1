package partA;

public class ShapeContainer {

	public static final int INIT_SIZE=10;
	public static final int RESIZE=10;
	private Drawable [] dr;
	int size=0;

	/**Construct */
	public ShapeContainer(){
		this.dr = new Drawable[INIT_SIZE];
		size = 0;
	}
	/** copy Construct */
	public ShapeContainer(ShapeContainer other){
		dr = new Drawable[other.dr.length];
		for (int i = 0; i < dr.length; i++) {
			if(other.dr[i] != null) {
				if(other.dr[i] instanceof Rectangle) {
					dr[i] = new Rectangle((Rectangle)other.dr[i]);
				}
				else {
					dr[i] = new Triangle((Triangle) other.dr[i]);
				}
			}
			size = dr.length;
		}
	}
	/** 
	 * @return how many triangle we have using count
	 */
	public int T_size() {
		int count  = 0;
		for (int i = 0; i < size; i++) {
			if (dr[i] instanceof Triangle && dr[i] != null )
				count++;
		}
		return count;
	}

	/** 
	 * @return how many rectangles we have using count
	 */
	public int R_size() {
		int count  = 0;
		for (int i = 0; i < size; i++) {
			if (dr[i] instanceof Rectangle && dr[i] != null)
				count++;
		}
		return count;
	}
	/**
	 * @return how many shapes we have using methods R_size() and T_size() 
	 */
	public int size() {
		return R_size()+T_size();
	}
	/**implements add function using resize if needed and updating size */
	public void add (Drawable d) {
		if(d != null) {
			if (d instanceof Rectangle) {
				if (size() >= dr.length) {
					resize();
				}
				dr[size] = d;
				size++;
			}
			else{
				if (size() >= dr.length) {
					resize();
				}
				dr[size] = d;
				size++;
			}
		}
	}
	/** Resizing the array using bigger array and moving all shapes*/
	private void resize() {
		// TODO Auto-generated method stub
		Drawable t[] = new Drawable[this.size + RESIZE];
		for (int i = 0; i < size; i++) {
			t[i] = dr[i];
		}
		this.dr = t;
	}

	/**
	 * remove all shapes which contains Point p using arraycopy and updates size 
	 * @param Point
	 */
	public void remove(Point p) {
		if(p!= null) {
			for (int i = 0; i < size; i++) {
				if(dr[i] != null && dr[i].contains(p)) {
					System.arraycopy(dr, i+1 , dr, i, dr.length - 1 - i);
					this.dr[size-1] = null;
					this.size--;
					i--;
				}
			}
		}
	}
	/**
	 * @param i
	 * @return a new copy of the triangle number i
	 */
	public Triangle T_at(int i) {
		int t =0;
		if( i < size() && dr[i] != null) {
			for (int j = 0; j < size; j++) {
				if (dr[j] instanceof Triangle) {
					if(t == i) {
						return new Triangle((Triangle) dr[j]);
					}
					t++;
				}
			}
		}
		return null;
	}
	/**
	 * @param i
	 * @return a new copy of the rectangle number i
	 */
	public Rectangle R_at(int i) {
		int t=0;
		if( i < size() && dr[i] != null) {
			for (int j = 0; j < size; j++) {
				if (dr[j] instanceof Rectangle) {
					if(t == i) {
						return new Rectangle((Rectangle) dr[j]);
					}
					t++;
				}
			}
		}
		return null;
	}
	/**
	 * @return the sum of the areas of all the triangles & rectangles
	 */
	public double sumArea() {
		double sum = 0;
		for (int i = 0; i < size; i++) {
			if(dr[i] instanceof Rectangle && dr[i] != null){
				Drawable temp = dr[i];
				sum += temp.area();
			}
			else if(dr[i] instanceof Triangle && dr[i] != null){
				Drawable temp = dr[i];
				sum += temp.area();
			}
		}
		return sum;
	}
	/**
	 * translate p using Point class
	 */
	public void translate(Point p) {
		if (p != null) {
			for (int i = 0; i < size; i++) {
				if(dr[i] !=null)
					dr[i].translate(p);
			}
		}
	}
	/**
	 * calculates and prints min and max perimeter of the shapes (triangles & rectangles) using minimum comparisons Algo1 
	 * @param num
	 */
	public void minMaxPerimeter(int num) {
		double min=-1;
		double max=-1;
		int comp=0;

		if(dr[1]!=null && dr[0]!=null){
			max=dr[0].perimeter();
			min=dr[1].perimeter();
			comp++;
		}
		if(dr[0].perimeter() < dr[1].perimeter()){
			max=dr[1].perimeter();
			min=dr[0].perimeter();
		}
		for (int i = 2;(( i < this.dr.length-1)&&(dr[i] != null &&dr [i+1] != null)); i=i+2){
			comp++;
			if(dr[i].perimeter() > dr[i+1].perimeter()){
				comp+=2;
				if(dr[i].perimeter() > max){
					max=dr[i].perimeter();
				}
				if(dr[i+1].perimeter() < min){
					min=dr[i+1].perimeter();
				}
			}
			else{
				comp +=2;
				if(dr[i].perimeter() < min){
					min=dr[i].perimeter();
				}
				if(dr[i+1].perimeter( ) > max){
					max=dr[i+1].perimeter();
				}
			}
		}
		if(this.dr.length%2 != 0 && dr[dr.length-1] != null){ //for odd num of elements
			comp++;
			if(dr[this.dr.length-1].perimeter() > max)
				max = dr[this.dr.length-1].perimeter();
			else{
				if(dr[this.dr.length-1].perimeter() < min) {
					min = dr[this.dr.length-1].perimeter();
				}
				comp++;
			}
		}
		System.out.println("number of comparison: " + comp);
		System.out.println("max perimeter: " + max);
		System.out.println("min perimeter: " + min);
	}
}

