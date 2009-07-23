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

/*
 * Special thanks to Google 'Summer of Code 2005' program for supporting this development
 * 
 * Contributors:
 * Majid Ali Khan - majidkk@users.sourceforge.net
 * Frank Sch�nheit - Frank.Schoenheit@Sun.COM
 */
package net.sf.jasperreports.engine.export.ooxml2;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.JasperPrint;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: ReportStyleHelper.java 2909 2009-07-21 16:21:50Z teodord $
 */
public class ReportStyleHelper extends BaseHelper
{
	/**
	 * 
	 */
	private CellHelper cellHelper = null;
	private ParagraphHelper paragraphHelper = null;
	
	/**
	 * 
	 */
	public ReportStyleHelper(Writer writer)
	{
		super(writer);
		
		cellHelper = new CellHelper(writer);
		paragraphHelper = new ParagraphHelper(writer, false);
	}

	/**
	 * 
	 */
	public void export(List jasperPrintList) throws IOException
	{
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		writer.write("<w:styles \r\n");
		writer.write(" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" \r\n");
		writer.write(" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\"> \r\n");
		writer.write(" <w:docDefaults> \r\n");
		writer.write("  <w:rPrDefault> \r\n");
		writer.write("   <w:rPr> \r\n");
		writer.write("    <w:rFonts w:ascii=\"Times New Roman\" w:eastAsia=\"Times New Roman\" w:hAnsi=\"Times New Roman\" w:cs=\"Times New Roman\"/> \r\n");
		writer.write("   </w:rPr> \r\n");
		writer.write("  </w:rPrDefault> \r\n");
		writer.write("  <w:pPrDefault> \r\n");
		writer.write("  </w:pPrDefault> \r\n");
		writer.write(" </w:docDefaults> \r\n");

		for(int reportIndex = 0; reportIndex < jasperPrintList.size(); reportIndex++)
		{
			JasperPrint jasperPrint = (JasperPrint)jasperPrintList.get(reportIndex);
			
			JRStyle[] styles = jasperPrint.getStyles();
			if (styles != null)
			{
				for(int i = 0; i < styles.length; i++)
				{
					JRStyle style = styles[i];
					exportHeader(style);
					cellHelper.exportProps(style);
					paragraphHelper.exportProps(style);
					exportFooter();
				}
			}
		}

		writer.write("</w:styles> \r\n");
	}
	
	/**
	 * 
	 */
	private void exportHeader(JRStyle style) throws IOException
	{
		writer.write(" <w:style w:type=\"paragraph\" w:default=\"1\" w:styleId=\"" + style.getName() + "\"> \r\n");
		writer.write("  <w:name w:val=\"" + style.getName() + "\" /> \r\n");
		writer.write("  <w:qFormat /> \r\n");
	}
	
	/**
	 * 
	 */
	private void exportFooter() throws IOException
	{
		writer.write(" </w:style> \r\n");
	}
	
}
