/*
 * Copyright (C) 2005-2011 Alfresco Software Limited.
 *
 * This file is part of Alfresco
 *
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 */
package org.alfresco.tools;

import static java.lang.System.setProperty;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Export. {@link org.alfresco.repo.security.person.PersonTest}
 * contains integration tests.
 * 
 * @author Alan Davis
 */
public class ExportTest {
	private String[] args;
	private File file;
	private Export export = new Export();

	@Before
	public void setUp() throws Exception {
		args = new String[12];
		args[0] = "-user";
		args[1] = "admin";
		args[2] = "-pwd";
		args[3] = "admin";
		args[4] = "-s";
		args[5] = "workspace://SpacesStore";
		args[6] = "-p";
		args[7] = "/app:company_home";
		args[8] = "-verbose";
		args[9] = "-root";
		args[10] = "-zip";
		args[11] = "test";
		file = new File(args[11] + ".acp");
		setProperty("dir.root", "./alf_data");
		setProperty("db.url",
				"jdbc:h2:./alf_data;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;LOCK_TIMEOUT=10000;MVCC=FALSE;LOCK_MODE=0");

	}

	@Before
	public void init() {
		deleteFile();
	}

	@After
	public void tearDown()// throws Exception
	{
		deleteFile();
	}

	@Test
	public void testExport() throws Exception {

		export.start(args);
		assertTrue(file.exists());
	}

	private void deleteFile() {
		if (file != null && file.exists()) {
			file.delete();
		}
	}
}
