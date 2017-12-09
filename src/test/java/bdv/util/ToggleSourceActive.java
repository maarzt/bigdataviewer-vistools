package bdv.util;

import net.imglib2.img.Img;
import net.imglib2.img.array.ArrayImgs;
import net.imglib2.type.numeric.ARGBType;
import net.imglib2.type.numeric.integer.IntType;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ToggleSourceActive {

	@Test
	public void testIsActive() {
		final Img<ARGBType> img = ArrayImgs.argbs( 10, 10, 10 );
		BdvStackSource<ARGBType> stackSource = BdvFunctions.show(img, "image");
		stackSource.setActive(true);
		assertTrue(stackSource.isActive());
		stackSource.setActive(false);
		assertFalse(stackSource.isActive());
	}

	@Test
	public void testGetColor() {
		final Img<IntType> img = ArrayImgs.ints( 10, 10, 10 );
		BdvStackSource<IntType> stackSource = BdvFunctions.show(img, "image");
		ARGBType expected = new ARGBType(Color.red.getRGB());
		stackSource.setColor(expected);
		ARGBType actual = stackSource.getColor();
		assertEquals(expected.get(), actual.get());
	}
}
