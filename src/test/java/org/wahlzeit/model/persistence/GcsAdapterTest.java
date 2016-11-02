package org.wahlzeit.model.persistence;

import com.google.appengine.tools.development.testing.LocalBlobstoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.Ignore;

/**
 * Test cases for the Google Cloud Storage adapter.
 * @review
 */
@Ignore
public class GcsAdapterTest extends AbstractAdapterTest {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalBlobstoreServiceTestConfig());

	@Override
	protected void storageDependentSetUp() {
		helper.setUp();
		imageStorage = new GcsAdapter.Builder().build();
	}

	@Override
	protected void storageDependentTearDown() {
		helper.tearDown();
	}
}
