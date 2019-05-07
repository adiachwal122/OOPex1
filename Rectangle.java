package partA;

public class Rectangle implements Drawable {

	private Point _Tp;
	private Point _Td;
	/**Constructor */
	public Rectangle(Point _p, Point _d) {
		this._Tp = (_p);
		this._Td = ( _d);
	}
	/**copy Constructor */
	public Rectangle(Rectangle other) {
		this._Tp = new Point( other._Tp);
		this._Td =  new Point(other._Td); 
	}
	/**empty Constructor */
	public Rectangle() {
		this._Tp = new Point(0,0);
		this._Td = new Point(0,0); 
	}
	/** checks if rectangle is equals to another rectangle using the points */
	@Override
	public boolean equals(Drawable d) {
		// TODO Auto-generated method stub
		if ((d instanceof Rectangle) ) {
			if (((Rectangle) d)._Tp.x() == this._Tp.x() && ((Rectangle) d)._Tp.y() == this._Tp.y()
					&& ((Rectangle) d)._Td.x() == this._Td.x() && ((Rectangle) d)._Td.y() == this._Td.y()){
				return true;
			}
		}
		return false;
	}
	/** checks if rectangle contains point */
	@Override
	public boolean contains(Point p) {
		if(p!=null) {
			if(p.x() >= this._Tp.x() && p.y()>= this._Tp.y() && p.x() <= this._Td.x() && p.y()<= this._Td.y() ) {
				return true;
			}
		}
		return false;
	}
	/**
	 * @return the perimeter of the rectangle */
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2*(Math.abs(_Td.x() - _Tp.x()) + Math.abs(_Td.y() - _Tp.y()));
	}
	/**
	 * @return the area of the rectangle */
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (Math.abs(_Td.x() - _Tp.x()) * Math.abs(_Td.y() - _Tp.y()));
	}
	/**
	 * translate p using Point class
	 */
	@Override
	public void translate(Point p) {
		// TODO Auto-generated method stub
		if(p != null) {
			_Tp.translate(p);
			_Td.translate(p);
		}
	}
	double dx() {
		return Math.abs(_Td.x() - _Tp.x());
	}

	double dy() {
		return Math.abs(_Td.y() - _Tp.y());
	}
	public Point p1() {
		return _Tp;
	}
	public Point p2() {
		return _Td;
	}
	@Override
	public String toString() {
		return "Rectangle [_Tp=" + _Tp + ", _Td=" + _Td + "]";
	}
/*	public static void main(String[] args) {
		Point a = new Point(1,1);
		Point b = new Point(2,3);
		Point t1 = new Point(1,1);
		//Point t2 = new Point(2,3);

		Rectangle test = new Rectangle(a,b);
		//Rectangle test1 = new Rectangle(t1,t2);

		//System.out.println("area is : " +test.area());
		//System.out.println(test.perimeter());
		System.out.println(test.contains(t1));
		//System.out.println(test.equals(test1));


		//	System.out.println(test);
	}*/
}
