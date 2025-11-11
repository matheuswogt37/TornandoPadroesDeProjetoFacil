// Representa os dados XML vindos do provedor
class XMLData {
    private String xml;

    public XMLData(String xml) {
        this.xml = xml;
    }

    public String getXML() {
        return xml;
    }
}

// Representa os dados JSON usados pela biblioteca Analytics
class JSONData {
    private String json;

    public JSONData(String json) {
        this.json = json;
    }

    public String getJSON() {
        return json;
    }
}

// Fonte de dados externa — fornece XML
class StockDataProvider {
    public XMLData getXMLData() {
        System.out.println("StockDataProvider: gerando dados em formato XML...");
        return new XMLData("<stock><symbol>VPR</symbol><price>100</price></stock>");
    }
}

// Core da aplicação — entende apenas XML
class CoreApplication {
    public void processData(XMLData xmlData) {
        System.out.println("CoreApplication: processando dados XML...");
        System.out.println("Dados recebidos: " + xmlData.getXML());
    }
}

// Biblioteca externa — entende apenas JSON
class AnalyticsLibrary {
    public void analyze(JSONData jsonData) {
        System.out.println("AnalyticsLibrary: analisando dados JSON...");
        System.out.println("Dados recebidos: " + jsonData.getJSON());
    }
}

// Adapter: converte XML em JSON para a biblioteca de análise
class XMLToJSONAdapter {
    private XMLData xmlData;

    public XMLToJSONAdapter(XMLData xmlData) {
        this.xmlData = xmlData;
    }

    public JSONData getJSONData() {
        System.out.println("Adapter: convertendo XML para JSON...");
        System.out.println("aqui vai a lógica da transcrição XML -> JSON...");
        String json = "{\"stock\": {\"symbol\": \"VPR\", \"price\": 100}}";
        return new JSONData(json);
    }
}

public class Main {
    public static void main(String[] args) {

        // Fornecedor de dados — retorna XML
        StockDataProvider stockProvider = new StockDataProvider();
        XMLData xmlData = stockProvider.getXMLData();

        // Core classes do sistema — trabalham com XML
//        CoreApplication core = new CoreApplication();
//        core.processData(xmlData);

        // Adapter converte XML para JSON para enviar à biblioteca de análise
        XMLToJSONAdapter adapter = new XMLToJSONAdapter(xmlData);
        AnalyticsLibrary analytics = new AnalyticsLibrary();
        analytics.analyze(adapter.getJSONData());
    }
}