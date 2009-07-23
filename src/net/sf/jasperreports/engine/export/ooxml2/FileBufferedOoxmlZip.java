/*
 * ============================================================================
 * GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2009 JasperSoft Corporation http://www.jaspersoft.com
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * JasperSoft Corporation
 * 539 Bryant Street, Suite 100
 * San Francisco, CA 94107
 * http://www.jaspersoft.com
 */
package net.sf.jasperreports.engine.export.ooxml2;

import java.io.IOException;

import net.sf.jasperreports.engine.export.zip.ExportZipEntry;
import net.sf.jasperreports.engine.export.zip.FileBufferedZipEntry;


/**
 * @author sanda zaharia (shertage@users.sourceforge.net)
 * @version $Id: FileBufferedOoxmlZip.java 2907 2009-07-21 13:53:45Z lucianc $
 */
public class FileBufferedOoxmlZip extends OoxmlZip
{

	/**
	 * 
	 */
	public FileBufferedOoxmlZip() throws IOException
	{
		super();
	}
	
	/**
	 * 
	 */
	public FileBufferedOoxmlZip(byte nature) throws IOException
	{
		super(nature);
	}
	
	/**
	 *
	 */
	public ExportZipEntry createEntry(String name)
	{
		return new FileBufferedZipEntry(name);
	}
	
}
