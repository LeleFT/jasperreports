/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.engine.xml;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.type.OrientationEnum;

import org.xml.sax.Attributes;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id$
 */
public class JasperPrintFactory extends JRBaseFactory
{

	/**
	 *
	 */
	public Object createObject(Attributes atts)
	{
		JasperPrint jasperPrint = new JasperPrint();
		
		jasperPrint.setName(atts.getValue(XmlConstants.ATTRIBUTE_name));

		String pageWidth = atts.getValue(XmlConstants.ATTRIBUTE_pageWidth);
		if (pageWidth != null && pageWidth.length() > 0)
		{
			jasperPrint.setPageWidth(Integer.parseInt(pageWidth));
		}

		String pageHeight = atts.getValue(XmlConstants.ATTRIBUTE_pageHeight);
		if (pageHeight != null && pageHeight.length() > 0)
		{
			jasperPrint.setPageHeight(Integer.parseInt(pageHeight));
		}

		OrientationEnum orientation = OrientationEnum.getByName(atts.getValue(XmlConstants.ATTRIBUTE_orientation));
		if (orientation != null)
		{
			jasperPrint.setOrientation(orientation);
		}
		
		String formatFactoryClass = atts.getValue(XmlConstants.ATTRIBUTE_formatFactoryClass);
		if (formatFactoryClass != null)
		{
			jasperPrint.setFormatFactoryClass(formatFactoryClass);
		}
		
		String locale = atts.getValue(XmlConstants.ATTRIBUTE_locale);
		if (locale != null)
		{
			jasperPrint.setLocaleCode(locale);
		}
		
		String timezone = atts.getValue(XmlConstants.ATTRIBUTE_timezone);
		if (timezone != null)
		{
			jasperPrint.setTimeZoneId(timezone);
		}

		return jasperPrint;
	}
	

}
