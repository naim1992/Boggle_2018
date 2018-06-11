/**
 * 
 */
var xmlHttpRequest = new XMLHttpRequest();

function readXml()
{
	xmlHttpRequest.open('GET','journal.xml', false);
	xmlHttpRequest.send();
	var xmlData=xmlHttpRequest.responseXML();
	if(!xmlData)
	{
		xmlData = (new DOMParser()).parseFromString(xml.responseText, 'text/xml');
		var session = xmlData.getElementsByTagName("session");
		var date = session[0].getElementsByTagName("date")[0].firstChild.data;
		
		document.write("Session = " + date + "<br>");
	}
}