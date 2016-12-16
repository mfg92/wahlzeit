package org.wahlzeit.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class ValueFactoryTest {

	private static class TestValueObject {
		public final int i;
		public final double d;

		public TestValueObject(int i, double d) {
			this.i = i;
			this.d = d;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof TestValueObject)) return false;

			TestValueObject that = (TestValueObject) o;

			if (i != that.i) return false;
			return Double.compare(that.d, d) == 0;
		}
	}

	ValueFactory<TestValueObject> factory = new ValueFactory<>(TestValueObject.class, Integer.TYPE, Double.TYPE);


	@Test
	public void testConstructorAndGetValueObjectEquals(){
		TestValueObject a = factory.getValueObject(42, 13.37);
		TestValueObject b = new TestValueObject(42, 13.37);
		Assert.assertEquals(a, b);
		Assert.assertNotSame(a, b);
	}

	@Test
	public void testSame(){
		TestValueObject a = factory.getValueObject(42, 13.37);
		TestValueObject b = factory.getValueObject(42, 13.37);
		Assert.assertEquals(a, b);
		Assert.assertSame(a, b);
	}

	@Test
	public void testNotSame(){
		TestValueObject a = factory.getValueObject(42, 13.37);
		TestValueObject b = factory.getValueObject(42, 13.371);
		Assert.assertNotEquals(a, b);
		Assert.assertNotSame(a, b);
	}
}
