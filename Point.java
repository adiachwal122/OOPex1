/**
 * this class represents a 2d point in the plane. <br>
 * supports several operations on points in the plane.
 */
package partA;

public class Point implements Drawable {

	// ******** private data ********
	private double _x, _y;

	// ********* constructors ********
	public Point (double x1, double y1) {
		_x = x1;
		_y = y1;
	}

	/** copy constructor:  
       1)here a direct access to a class memeber is performed,
         this will be done only in a constractor to achieve an identical copy
       2) using a call to another constractor code is not written twice
	 */  
	public Point (Point p) { this(p._x, p._y);}

	// ********** public methodes *********
	public double x() {return _x;}
	public double y() {return _y;}

	/** @return a String contains the Point data*/

	/**    logical equals 
   @param p other Object (Point).
   @return true iff p instance of Point && logicly the same) */
	/*public boolean equals (Point p) {
		return p!=null && p._x == _x && p._y==_y; }*/

	@Override
	public boolean equals(Drawable d) {
		// TODO Auto-generated method stub
		return d instanceof Point && _x == ((Point) d)._x && _y == ((Point) d)._y;

	}
	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return ((p._x == this._x) && (p._y == this._y));
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}
	/** translate is similar to Point class in Java
	 * @return Point after translate
	 */
	@Override
	public void translate(Point p) {
		// TODO Auto-generated method stub
		if(p != null){
			this._x = this._x + p._x;
			this._y = this._y + p._y;
		}
		else{
			System.err.println("Point can not be null ");
		}
	}
	/** calculate distance 
	 * @param Point
	 * @return distance between p and this.p
	 */
	public double distance(Point p) {
		if (p == null) {
			return 0;
		}
		double dx =(p._x - this._x), dy = (p._y - this._y);
		return Math.sqrt(dx * dx + dy * dy);
	}

	public String toString()  {
		return "name: " + this.getClass() +"[" + _x + "," + _y+"]";
	}
}// class Point