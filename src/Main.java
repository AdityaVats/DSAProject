
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import sun.plugin.javascript.navig.Array;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by libsys on 1/12/2021.
 */
interface P1{
    void f1();
    void f2();
    void f3();
}
interface P2{
    void f1();
    void f2();
    void f4();
}
interface C1 extends P1,P2{

}
class CC implements C1{
    @Override
    public void f1() {

    }

    @Override
    public void f2() {

    }

    @Override
    public void f3() {

    }

    @Override
    public void f4() {

    }
}
public class Main {
    public static void func(){
        MimeBodyPart body = new MimeBodyPart();
        body.setText("Aditya      Vats");

    }

    private static int getLineNumber(File file, String word) throws Exception {
        // TODO Auto-generated method stub
        String line;
        boolean flag = true;
        BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file))));
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

        while((line = br.readLine())!=null) {
            if(flag && line.contains(word)) {

                randomAccessFile.writeBytes("\n//test\n");
                flag = !flag;
            }
//			randomAccessFile.writeBytes(line+"\n");
        }
        randomAccessFile.close();
        return -1;
    }
    public static void  func1(){
        String word = "Class";
        String path  ="C:\\Users\\libsys\\Desktop\\hello.txt" ;
        try {
			/*List<String> lists= Files.lines(Paths.get(path)).collect(Collectors.toList());

			int idx = -1;
			for (int i = 0; i < lists.size(); i++) {
				if(lists.get(i).contains(word)) {
					idx = i;
					break;
				}
			}
			PrintWriter printWriter = new PrintWriter(new File(path));
			for(int i=0;i<lists.size();i++) {
				if(i==idx) {
					printWriter.write("\n//test\n");
				}
				printWriter.write(lists.get(i)+"\n");
			}
			printWriter.close();*/
            getLineNumber(new File(path), word);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /*public static String hex_to_alphanum(String s, int opt) {
        System.out.println("*********** IN HEX TO ALPHA METHOD**************");
        System.out.println("Hex String :"  + s);
        if (s == null || s.trim().length() == 0)
            return null; //String contains no chars

        int i = 0, j = 0, temp, k = 0, times = 0;
        double exp = 1, num = 0, num1 = 0;
        int a = 0;
        String res = "";

        if (opt == 2) {
            s = s.trim();
            i = 0;
            do {
                for (j = i; j < i + 2; j++) {
                    temp = assign_int(s.charAt(j));
                    num = temp * Math.pow((double) 16, exp);
                    num1 = num1 + num;
                    exp--;
                }
                i = j;
                res = res + (char) num1;
                num = 0;
                exp = 1;
                num1 = 0;
                k++;
                j += 2;
            } while (i < s.length() - 1);//Changed 15 to 30 14/4/2010 to read call no of length 30
            return res;
        }
        boolean endsWithAlpha=false;
        if (opt == 1) {
            do {
                if (!(s.substring(i, 2).equals("24"))) {
                    for (j = i; j < i + 2; j++) {
                        temp = assign_int(s.charAt(j));
                        num = temp * Math.pow((double) 16, exp);
                        num1 = num1 + num;
                        exp--;
                    }
                    i = j;
                    res = res + (char) num1;
                    num = 0;
                    exp = 1;
                    num1 = 0;
                    k++;
                } else
                    i += 2;
                j += 2;
            } while (i < 4);
            i = 4;
            if(s.endsWith("25")){
                System.out.println("Swapping case removing 25!!");
                s = s.substring(0,s.length()-2);
                endsWithAlpha = true;
            }

        }
        while (s.substring(i).startsWith("0")) {
            res = res + "0";
            i = i + 1;
        }
        times = s.length() - i;

        if (times > 0) {
            exp = times - 1;
            for (j = i; j < i + times; j++) {
                temp = assign_int(s.charAt(j));
                num = temp * Math.pow((double) 16, exp);
                num1 = num1 + num;
                exp--;
            }
            i = j;
            res = res + num1;
            num = 0;
            exp = 1;
            num1 = 0;
            k++;
        }

        if (res.charAt(res.length() - 2) == 'E' && res.contains(".")) {
            res=res.substring(0,res.indexOf("."))+res.substring(res.indexOf(".")+1,res.length()-2);
        }
        if (res.indexOf(".") == -1) {
            System.out.println("Alpha String : " + res);

        }
        else{
            System.out.println("Alpha String : " + res.substring(0, res.lastIndexOf('.')));

            res =  res.substring(0, res.lastIndexOf('.'));
        }
        if(endsWithAlpha){
            int alphaLength = 1;
            if(res.length()>2 && res.charAt(1)>='A' && res.charAt(1)<='Z'){
                alphaLength ++;
            }
            res =  res.substring(alphaLength) + res.substring(0,alphaLength);
            System.out.println("Swapping Condition final Value:" + res);
        }
        return res;
    }*/
    private static int assign_int(char s) {
        int num = 0;
        if (s >= '0' && s <= '9')
            num = s - '0';
        if (s >= 'A' && s <= 'F')
            num = s - 'A' + 10;
        return num;
    }

    public static byte[] ConvertTagIDStringToByte(String tagId) {
        int i = 0, j, temp, exp = 1;
        double num1 = 0, num;
        int len = tagId.length();
        if (len % 2 == 1) len++;
        byte tagIdInByte[] = new byte[len / 2];
        tagId = tagId.trim();

        for (i = 0; i < tagId.length(); ) {
            for (j = i; j < i + 2; j++) {
                temp = assign_int(tagId.charAt(j));
                num = temp * Math.pow((double) 16, exp);
                num1 = num1 + num;
                exp--;
            }
            tagIdInByte[i / 2] = (byte) num1;
            num1 = 0;
            exp = 1;
            i = j;
        }
        return tagIdInByte;
    }
    public static void main(String[] args) throws Exception {
        int width[] ={10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    String s[] ={"word","world","row"};
        String str = "17/11/2021 16:52:45\u001EIN\u001E(76818) The 3 Mistakes of my Life (null)\u001E04/12/2021\u001Enull\u001E\u001E";
        String[] arr=str.split("");
        int xxxx[] = {10,20,21,21,21};

        str.length();
        func();
        byte[] b1 = ConvertTagIDStringToByte("E2801160200075A0B3D40909");
        byte []b2 = "E2801160200075A0B3D40909".getBytes();
        String var = "abc\r".replace("\r","");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> l2 = list.stream().filter(i -> i%2==0).map(i->i+5).collect(Collectors.toList());

        connect();

        long AFIdata =  Long.parseLong("90",16);
        AFIdata &= 0xff;
        if(false && false && false || true){
          System.out.println("HELLOO");
        }
        int a = 100;
        int b = 9;
        boolean assa=1==1.0;
        double c = Math.ceil(a/(b*1.0));
        String xyz ="sn|jk|nvjnvfdjn";
        String[] l = xyz.split("\\|");
        System.out.print(xyz.substring(0,0));
        String tokenRegex = "TOKENID( )+=( )+'([^']+)'";

        Matcher matcher = Pattern.compile(tokenRegex).matcher("TOKENID = '101909091' as\"\"");
        String tokenId="";
        while(matcher.find()){
            tokenId = matcher.group(3);
        }
        String x = null;
        if(x.equalsIgnoreCase("1")){
            System.out.print("");
        }
        String outputXml ="<?xml version=\"1.0\" encoding=\"utf-8\"?><NCIPMessage version=\"2.0\">\n" +
                "<LookupItemResponse><ResponseHeader><FromSystemId Scheme=\"\" />     <FromAgencyId><AgencyId Scheme=\"\" /></FromAgencyId><ToSystemId Scheme=\"\" /> <ToAgencyId><AgencyId Scheme=\"\" /></ToAgencyId></ResponseHeader>  <ItemId><AgencyId Scheme=\"\">RESGRM0001</AgencyId><ItemIdentifierType Scheme=\"\">Barcode</ItemIdentifierType><ItemIdentifierValue>000015</ItemIdentifierValue></ItemId>  <DateRecalled></DateRecalled><HoldPickupDate></HoldPickupDate><ItemOptionalFields><BibliographicDescription><Author>XYZ</Author><BibliographicItemId><BibliographicItemIdentifier /> <BibliographicItemIdentifierCode Scheme=\"\">901520118</BibliographicItemIdentifierCode></BibliographicItemId><Edition>1</Edition><Publisher>pqr</Publisher><Title>ABC Book</Title><BibliographicLevel Scheme=\"\"></BibliographicLevel><MediumType>Textbook</MediumType></BibliographicDescription><CirculationStatus>Available</CirculationStatus><HoldQueueLength>1</HoldQueueLength><ItemDescription><CallNumber>202</CallNumber><CopyNumber>2</CopyNumber></ItemDescription><ItemUseRestrictionType Scheme=\"\" /><Location> <LocationType>4</LocationType><LocationName><LocationNameInstance><LocationNameLevel>2</LocationNameLevel><LocationNameValue>1</LocationNameValue></LocationNameInstance><LocationNameInstances><LocationNameInstance><LocationNameLevel>0</LocationNameLevel><LocationNameValue>Main</LocationNameValue></LocationNameInstance></LocationNameInstances></LocationName></Location></ItemOptionalFields><ItemTransaction /></LookupItemResponse></NCIPMessage>" ;
        HashMap<String, String> map = xmlTagsInfo("itemlookupresponse",outputXml);
        System.out.print(map.size());
        StringBuffer requestQuery = new StringBuffer(getItemLookup());
        requestQuery = new StringBuffer(requestQuery.toString().replaceAll("(</AgencyId>)","RESGRM0025"+"$1"));
        requestQuery.insert(requestQuery.indexOf("</ItemIdentifierType>"), "barcode");

        requestQuery.insert(requestQuery.indexOf("</ItemIdentifierValue>"), "70000");
        String request = requestQuery.toString();
        int elementIndex = request.indexOf("</UserElementType>");
        List<String> itemElementType = new ArrayList<>();
        itemElementType.add("Bibliographic Description");
        itemElementType.add("Circulation Status");
        itemElementType.add("Electronic Resource");
        itemElementType.add("Hold Queue Length");
        itemElementType.add("Item Description");
        itemElementType.add("Item Use Restriction Type");
        itemElementType.add("Location");
        itemElementType.add("Physical Condition");
        for(int i=0;i<itemElementType.size();i++){
            if(elementIndex!=-1){
                request = request.substring(0,elementIndex)+itemElementType.get(i)+request.substring(elementIndex);
                elementIndex = request.indexOf("</ItemElementType>",elementIndex+itemElementType.get(i).length()+18);
            }
        }
        System.out.print(request);


        //
        // input="4C004C";

       /* byte[] b = DatatypeConverter.parseHexBinary("E00401081FE7CCD2");
        b = DatatypeConverter.parseHexBinary("E00401081CB248B8");
        char[] HEX_ARRAY ="0123456789ABCDEF".toCharArray();
        char[] hex = new char[b.length*2];
            for(int i=0;i<b.length;i++){
                int v = b[i]& 0xFF ;
                hex[i*2] = HEX_ARRAY[v >>> 4];
                hex[i*2+1] = HEX_ARRAY[v & 0x0F];
            }
        System.out.println(new String(hex));
        System.out.println(DatatypeConverter.printHexBinary(b));*/
          /*  Properties properties = new Properties();
            properties.put("jboss.naming.client.ejb.context", "true"); //make context false for ear build
            properties.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
            properties.put("java.naming.provider.url", "http-remoting://192.200.1.122:8180");
            properties.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
            properties.put("java.naming.security.principal", "libsys");
            properties.put("java.naming.security.credentials", "libsys");
        InitialContext context = null;

        try {
            context = new InitialContext(properties);
        } catch (NamingException var8) {
            var8.printStackTrace();
        }

        String jndiName = "LS_KOHA/ObjectMakerBean!ls.koha.init.init.ObjectMakerRemote";
        jndiName = "LS_KOHA/CommonBean!ls.koha.init.init.CommonRemote";
        jndiName = "jmartKoha/LS_KOHA/CommonBean!ls.koha.init.init.CommonRemote";
        System.out.println(jndiName);
        if(context != null) {
            try {
                CommonRemote commonRemote = (CommonRemote) context.lookup(jndiName);
                System.out.printf("here");
               // System.out.print(commonRemote.init("908720210112    140000AOnull|AA1|CNnull|AEnull|AMnull")); ;
                System.out.print(commonRemote.init("9083"));
            } catch (NamingException var7) {
                var7.printStackTrace(System.out);
                //  throw new LSUIException(var7);
            }
        }*/
        /*String s = "aac";
        printPerm(s," ");
        */

    }
    public static HashMap<String, String> xmlTagsInfo(String name, String response) throws ParserConfigurationException {


        int i, j = 0, k = 0, len;

        HashMap<String, ArrayList<TreeComponent>> map = null;
        try {
            map = readNcipTags();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<TreeComponent> arrayList = map.get(name);
        len = arrayList.size();
        String[] tags = new String[len];
        HashMap<String, String> tagValues = new HashMap();
        for (TreeComponent tree : arrayList) {
            tags[j] = tree.getTitle();
            j++;
        }
        response = response.replaceAll("[<][n][s][1][:]","<");
        response = response.replaceAll("[<][/][n][s][1][:]","</");
        for(String tag :tags){
            if(response.indexOf("<" + tag + ">")>0 && response.indexOf("</" + tag + ">")>0){
                int startIndex = response.indexOf("<" + tag + ">")+tag.length()+2;
                int endIndex = response.indexOf("</" + tag + ">");
                tagValues.put(tag,response.substring(startIndex,endIndex));
            }
        }

        return tagValues;
    }
    public static HashMap<String, ArrayList<TreeComponent>> readNcipTags() throws FileNotFoundException {

        String name = "";
        int i = 1;
        String url = "C:"+File.separator+"Users"+File.separator+"libsys"+File.separator+"Desktop"+File.separator+"TcsTags.txt";
        File file = new File(url);
        FileReader fileReader = new FileReader(file);
        HashMap<String, ArrayList<TreeComponent>> hashMap = new HashMap();
        ArrayList<TreeComponent> list = new ArrayList();
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()) {

            String currString = scanner.nextLine();
            if (currString.startsWith("#")) {
                if (i == 1) {
                    i++;
                } else {
                    hashMap.put(name, list);
                    list = null;
                    list = new ArrayList();
                }
                name = currString.substring(1);
                currString = scanner.nextLine();
            }

            if (currString.startsWith("$")) {
                hashMap.put(name, list);
                break;
            }

            String[] str = currString.split(":");
            String currId = str[0];
            String parentId = str[1];
            String title = str[2];
            TreeComponent treeComponent = new TreeComponent();
            treeComponent.setId(currId);
            treeComponent.setPid(parentId);
            treeComponent.setTitle(title);
            list.add(treeComponent);
        }
        return hashMap;
    }
    public static String getItemLookup(){
        return "<?xml version = '1.0' encoding = 'UTF-8'?>\n" +
                "<NCIPMessage xmlns=\"http://www.niso.org/2008/ncip\" version=\"http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd\"><LookupItem>\n" +
                "<InitiationHeader>\n" +
                "<FromAgencyId>\n" +
                "<AgencyId></AgencyId>\n" +
                "</FromAgencyId>\n" +
                "<ToAgencyId>\n" +
                "<AgencyId></AgencyId>\n" +
                "</ToAgencyId>\n" +
                "<FromSystemId></FromSystemId>\n" +
                "</InitiationHeader>\n" +
                "<ItemId>\n" +
                "<AgencyId></AgencyId>\n" +
                "<ItemIdentifierType></ItemIdentifierType>\n" +
                "<ItemIdentifierValue></ItemIdentifierValue>\n" +
                "</ItemId>\n" +
                "<ItemElementType>\n" +
                "<Value></Value>\n" +
                "</ItemElementType>\n" +
                "<ItemElementType>\n" +
                "<Value></Value>\n" +
                "</ItemElementType>\n" +
                "<ItemElementType>\n" +
                "<Value></Value>\n" +
                "</ItemElementType>\n" +
                "<ItemElementType>\n" +
                "<Value></Value>\n" +
                "</ItemElementType>\n" +
                "<ItemElementType>\n" +
                "<Value></Value>\n" +
                "</ItemElementType>\n" +
                "<ItemElementType>\n" +
                "<Value></Value>\n" +
                "</ItemElementType>\n" +
                "<CurrentBorrowerDesired></CurrentBorrowerDesired>\n" +
                "<CurrentRequestersDesired></CurrentRequestersDesired>\n" +
                "</LookupItem>\n" +
                "</NCIPMessage>\n";
    }
    public static String getUserLookup(){
        return "<?xml version = '1.0' encoding = 'UTF-8'?>\n" +
                "<NCIPMessage xmlns=\"http://www.niso.org/2008/ncip\" version=\"http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd\">\n" +
                "<LookupUser>\n" +
                "<InitiationHeader>\n" +
                "<FromAgencyId>\n" +
                "<AgencyId></AgencyId>\n" +
                "</FromAgencyId>\n" +
                "<ToAgencyId>\n" +
                "<AgencyId></AgencyId>\n" +
                "</ToAgencyId>\n" +
                "<FromSystemId></FromSystemId>\n" +
                "</InitiationHeader>\n" +
                "<UserId>\n" +
                "<UserIdentifierValue></UserIdentifierValue>\n" +
                "</UserId>\n" +
                "<UserElementType>\n" +
                "<Value></Value>\n" +
                "</UserElementType>\n" +
                "<UserElementType></UserElementType>\n" +
                "<UserElementType></UserElementType>\n" +
                "<UserElementType></UserElementType>\n" +
                "<LoanedItemsDesired></LoanedItemsDesired>\n" +
                "<UserFiscalAccountDesired></UserFiscalAccountDesired>\n" +
                "</LookupUser>\n" +
                "</NCIPMessage>\n";
    }


public static void connect(){

            DatagramSocket ds;
            try {

                ds = new DatagramSocket(4001, InetAddress.getByName("192.200.1.122"));

                System.out.println("Connected..");
                byte[] receive = new byte[65535];
                /*for(int i=0;i<65535;i++) {
                    receive[i] = Byte.MAX_VALUE;
                }*/
                DatagramPacket DpReceive = null;
                while (true)
                {

                    // Step 2 : create a DatgramPacket to receive the data.
                    DpReceive = new DatagramPacket(receive, receive.length);
                    System.out.print("Waiting......");
                    // Step 3 : receive the data in byte buffer.
                    ds.receive(DpReceive);


                    System.out.println("PACKET CAUGHT-->" );
                    int counter;
                    for(counter=0 ;counter<receive.length;counter++) {
                        int x =receive[counter] &0xff;
                        System.out.print(receive[counter]+"|");
                    }
                    //displayMsg(receive);
                    byte[] response = new byte[counter];
                    for(int i=0;i<counter;i++) {
                        response[i] = receive[i];
                    }
                    // Clear the buffer after every message.
                    receive = new byte[65535];
                    for(int i=0;i<65535;i++) {
                        receive[i] = -1;
                    }
                }
            } catch(IOException e) {
                e.printStackTrace();

            }
        }


    private StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
    private StringBuilder binaryDataToString(byte[] a) {
        if(a==null)
            return null;
        StringBuilder str = new StringBuilder();
        return null;
    }
    private static byte[] getMemory(byte[] data){
        System.out.println("----------");
        if(data[18] == 0){
            if(data[19]==3){
                int length = data[25];
                if(length==40){
                    byte[] memory = new byte[32];
                    for(int i=0;i<length-8;i++){
                        memory[i] = data[i+34];
                        System.out.print(memory[i]+"|");
                    }
                    return memory;
                }
            }
        }
     return null;

    }







}




