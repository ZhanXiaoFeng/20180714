package com.demo;

import java.util.Hashtable;

import com.demo.dao.Shape;
import com.demo.dao.impl.Circle;
import com.demo.dao.impl.Rectangle;
import com.demo.dao.impl.Square;

public class ShapeCache {

	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}

	// ��ÿ����״���������ݿ��ѯ������������״
	// shapeMap.put(shapeKey, shape);
	// ���磬����Ҫ���������״
	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);

		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);

		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}
