<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<serviceId><xsl:value-of select="root/idFactura"/></serviceId>
		<value><xsl:value-of select="root/valorFactura"/></value>
	</xsl:template>
</xsl:stylesheet>