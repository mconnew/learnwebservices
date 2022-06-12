@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.soap.*


def client = new SOAPClient('https://apps.learnwebservices.com/services/hello')
def response = client.send {
    body {
        HelloRequest('xmlns':'http://learnwebservices.com/services/hello') {
          Name("John Doe")
        }
    }
}

/*def response = client.send("""
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header/>
   <soapenv:Body>
      <SayHello xmlns="http://learnwebservices.com/services/hello">
         <HelloRequest>
            <Name>John Doe</Name>
         </HelloRequest>
      </SayHello>
   </soapenv:Body>
</soapenv:Envelope>
""")*/


println(response.text)

println(response.HelloResponse.Message)