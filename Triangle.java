package partA;

public class Triangle implements Drawable {

	private Point _Tx;
	private Point _Ty;
	private Point _Tz;
	/**Constructor */
	public Triangle(Point _x, Point _y, Point _z) {
		this._Tx = (_x);
		this._Ty = (_y);
		this._Tz = (_z);
	}
	/**empty Constructor */
	public Triangle() {
		this._Tx = new Point(0,0);
		this._Ty = new Point(0,0);
		this._Tz = new Point(0,0);
	}
	/**copy Constructor */
	public Triangle(Triangle other) {
		this._Tx = new Point(other._Tx);
		this._Ty =  new Point(other._Ty);
		this._Tz = new Point( other._Tz);
	}
	/** checks if triangle is equals to another triangle using the points */
	@Override
	public boolean equals(Drawable d) {
		// TODO Auto-generated method stub
		if ((d instanceof Triangle) ) {
			if (((Triangle) d)._Tx.x() == this._Tx.x() && ((Triangle) d)._Tx.y() == this._Tx.y()
					&& ((Triangle) d)._Ty.x() == this._Ty.x() && ((Triangle) d)._Ty.y() == this._Ty.y()
					&& ((Triangle) d)._Tz.x() == this._Tz.x() && ((Triangle) d)._Tz.y() == this._Tz.y() ){
				return true;
			}
		}
		return false;
	}
	/** checks if triangle contains point by creating new 3 triangles and comparing the sum area */
	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		if (p != null) {
			Triangle t1 = new Triangle(_Tx, _Ty, p);
			Triangle t2 = new Triangle(_Tx, p, _Tz);
			Triangle t3 = new Triangle(p,_Ty,_Tz);
			double sum = t1.area() + t2.area() + t3.area();
			if (Math.abs(this.area()-sum)<=0.001) {
				return true;
			}
		}
		return false;
	}
	/**
	 * @return the perimeter of the triangle using distance from class Point
	 */
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return (_Tx.distance(_Ty)+_Ty.distance(_Tz)+_Tz.distance(_Tx));
	}
	/**
	 * @return the area of the triangle using formula and distance from class Point
	 */
	@Override
	public double area() {
		// TODO Auto-generated method stub
		double sideA = _Tx.distance(_Ty);
		double sideB = _Tz.distance(_Ty); 
		double sideC = _Tx.distance(_Tz);
		double s = (0.5) * (sideA + sideB + sideC);
		return Math.sqrt(s*(Math.abs(s-sideA))*(Math.abs(s-sideB))*(Math.abs(s-sideC)));
	}
	/**
	 * translate p using Point class
	 */
	@Override
	public void translate(Point p) {
		// TODO Auto-generated method stub
		if(p != null) {
			_Tx.translate(p);
			_Ty.translate(p);
			_Tz.translate(p);
		}
	}
	public Point p1() {
		return _Tx;
	}
	public Point p2() {
		return _Ty;
	}
	public Point p3() {
		return _Tz;
	}
	@Override
	public String toString() {
		return "Triangle [_Tx=" + _Tx + ", _Ty=" + _Ty + ", _Tz=" + _Tz + "]";
	}

	/*public static void main(String[] args) {
		Point a = new Point(122,145);
		Point b = new Point(133,146);
		Point c = new Point(123,63);

		Triangle test = new Triangle(a,b,c);


		Point a1 = new Point(123,63);
		Point b1 = new Point(3,4);
		Point c1 = new Point(6,0);

		Triangle test1 = new Triangle(a1,b1,c1);
		System.out.println(test.contains(a1));

		System.out.println(test.area());
	}*/
}
