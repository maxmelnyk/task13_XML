<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <head>
        <style type="text/css">
          table.myGems {
          border: 1px ;
          }

          td.color {
          border: 10px ;
          background-color: yellow;
          color: red;
          text-align:right;
          }

          th {
          background-color: #2E9AFE;
          color: white;
          }

        </style>
      </head>

      <body style="font-family: Arial; font-size: 12pt; background-color: #EEE">
        <div style="background-color: red; color: black;">
          <h2>My Gems</h2>
        </div>
        <table class="meGems">
          <tr>
            <th style="width:50px">ID</th>
            <th style="width:250px">name</th>
            <th style="width:350px">preciousness</th>
            <th style="width:250px">origin</th>
            <th style="width:250px">color</th>
            <th style="width:250px">transparency</th>
            <th style="width:250px">wayOfCutting</th>
            <th style="width:250px">value</th>
          </tr>

          <xsl:for-each select="gems/gem">
            <tr>
              <td class="color"><xsl:value-of select="@gemID"/></td>
              <td class="color"><xsl:value-of select="name" /></td>
              <td class="color"><xsl:value-of select="preciousness" /></td>
              <td class="color"><xsl:value-of select="origin" /></td>
              <td class="color"><xsl:value-of select="visualParameters/color" /></td>
              <td class="color"><xsl:value-of select="visualParameters/transparency" /></td>
              <td class="color"><xsl:value-of select="visualParameters/wayOfCutting" /></td>
              <td class="color"><xsl:value-of select="value" /></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>