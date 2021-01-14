package org.janelia.saalfeldlab.hotknife;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.janelia.saalfeldlab.n5.DataType;
import org.junit.Test;

import net.imglib2.RandomAccessibleInterval;
import net.imglib2.img.Img;
import net.imglib2.type.numeric.integer.UnsignedByteType;

public class CorrectlyPaddedDistanceTransformTest {

	@Test
	public void testGetCorrectlyPaddedDistanceTransform() {
	    long [] offset= {0,0,0};
	    long [] dimension = {10,10,10};
	    Img<UnsignedByteType> halfFull = TestImageMaker.halfFull(dimension);
	    CorrectlyPaddedDistanceTransform cpdt = new CorrectlyPaddedDistanceTransform(halfFull, offset, dimension, 0);
	    
	    //TODO: Compare actual output array
	    
	    assertArrayEquals(cpdt.padding,new long[] {16,16,16});
	    assertArrayEquals(cpdt.paddedOffset,new long[] {offset[0]-16, offset[1]-16, offset[2]-16});
	    assertArrayEquals(cpdt.paddedDimension,new long[] {dimension[0]+2*16, dimension[1]+2*16, dimension[2]+2*16});

	}

}
