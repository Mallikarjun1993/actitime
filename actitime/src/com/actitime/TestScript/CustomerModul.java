package com.actitime.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.Basecls;
@Listeners(com.actitime.generic.ListenerImplementationCls.class)

	public class CustomerModul extends Basecls{

		@Test
		public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Create Customer",true);
		Thread.sleep(5000);
}
}