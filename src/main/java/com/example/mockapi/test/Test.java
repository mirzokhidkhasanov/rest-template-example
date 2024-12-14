package com.example.mockapi.test;

import com.example.mockapi.model.crif.schemes.MGResponse;
import com.example.mockapi.model.crif.schemes.MessageIdempotence;
import com.example.mockapi.model.crif.schemes.MessageResponse;
import com.example.mockapi.model.gcp.schemes.CEPResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static Map<String, String> getAllHeaders(HttpServletRequest request) {
        Map<String, String> headersMap = new HashMap<>();
        Collections.list(request.getHeaderNames()).forEach(headerName -> headersMap.put(headerName, request.getHeader(headerName)));
        return headersMap;
    }

    public static String getMGResponseStringXml() {
        return "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "        <MGResponse xmlns=\"urn:cbs-messagegatewaysoap:2015-01-01\">\n" +
                "            <MessageResponse GroupId=\"b54c2e5a-e99b-467b-98c8-f8b5553e2e11\" Id=\"a2fbe3d6-a084-41a5-a973-bf0d09fca031\" TimeStamp=\"2016-01-28T23:55:25.7523188+05:00\" Idempotence=\"unique\" ExpirationTimeStamp=\"2023-07-13T06:08:29.560331Z\" ResultLanguage=\"en-US\" ResultCode=\"S\" ResultDescription=\"Success.\">\n" +
                "                <CredentialsResponse Domain=\"\" Id=\"PIGY9962\" Password=\"********\" ResultLanguage=\"en-US\" ResultCode=\"S\" ResultDescription=\"Success.\"/>\n" +
                "            </MessageResponse>\n" +
                "            <ProductResponse ServiceId=\"CBG\" Id=\"CB_NAE_Product\" Version=\"CB_NAE_Product.2023-06-16.001\" ResultLanguage=\"en-US\" ResultCode=\"S\" ResultDescription=\"Success.\">\n" +
                "                <cb:CB_NAE_ProductOutput xmlns:cb=\"urn:crif-creditbureau:v1\">\n" +
                "                    <cb:MessageId CBSMessageId=\"a2fbe3d6-a084-41a5-a973-bf0d09fca031\" CBSLogUID=\"b1558b06-69ba-45a3-882e-364ef6577d5b\"/>\n" +
                "                    <cb:Error Code=\"1-089\" Description=\"THE SUBJECT IS ALREADY LINKED TO THE CONTRACT\"/>\n" +
                "                </cb:CB_NAE_ProductOutput>\n" +
                "            </ProductResponse>\n" +
                "        </MGResponse>\n" +
                "    </s:Body>\n" +
                "</s:Envelope>";
    }


    public static MGResponse getMGResponse() throws DatatypeConfigurationException {
        MGResponse mgResponse = new MGResponse();
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setGroupId("b54c2e5a-e99b-467b-98c8-f8b5553e2e11");
        messageResponse.setId("a2fbe3d6-a084-41a5-a973-bf0d09fca031");
        messageResponse.setTimeStamp(getXmlGregorianCalendarByZoneDateTime("2016-01-28T19:55:25.7523188+01:00"));
        messageResponse.setIdempotence(MessageIdempotence.UNIQUE);
        mgResponse.setMessageResponse(messageResponse);

        return mgResponse;
    }

    public static XMLGregorianCalendar getXmlGregorianCalendarByZoneDateTime(String date) throws DatatypeConfigurationException {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(date);
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(zonedDateTime);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        return xmlGregorianCalendar;
    }


    @NotNull
    public static String getSoapXmlCepResponse() {
        return "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <env:Header/>\n" +
                "   <env:Body>\n" +
                "      <CEPResponse xmlns=\"http://fido.com/EasuEGServices\">\n" +
                "         <Result>1</Result>\n" +
                "         <Data><![CDATA[<?xml version=\"1.0\"?>\n" +
                "<datacepresponse>\n" +
                "<row>\n" +
                "<document>*********</document>\n" +
                "<surname_latin>TEST</surname_latin>\n" +
                "<name_latin>TEST</name_latin>\n" +
                "<patronym_latin>TEST</patronym_latin>\n" +
                "<surname_engl/>\n" +
                "<name_engl/>\n" +
                "<birth_date>1988-06-05</birth_date>\n" +
                "<birth_place>TOSHKENT</birth_place>\n" +
                "<birth_place_id/>\n" +
                "<birth_country>ЎЗБЕКИСТОН</birth_country>\n" +
                "<birth_country_id>182</birth_country_id>\n" +
                "<livestatus>1</livestatus>\n" +
                "<nationality>ЎЗБЕК</nationality>\n" +
                "<nationality_id>44</nationality_id>\n" +
                "<citizenship>ЎЗБЕКИСТОН</citizenship>\n" +
                "<citizenship_id>182</citizenship_id>\n" +
                "<sex>1</sex>\n" +
                "<doc_give_place>ТОШКЕНТ ШАҲАР ЯККАСАРОЙ ТУМАНИ ИИБ</doc_give_place>\n" +
                "<doc_give_place_id>26287</doc_give_place_id>\n" +
                "<date_begin_document>2022-22-04</date_begin_document>\n" +
                "<date_end_document>2032-21-04</date_end_document>\n" +
                "</row>\n" +
                "</datacepresponse>]]></Data>\n" +
                "         <Comments/>\n" +
                "      </CEPResponse>\n" +
                "   </env:Body>\n" +
                "</env:Envelope>";
    }


    public static CEPResponse getResponseXml() {
        CEPResponse cepResponse = new CEPResponse();
        cepResponse.setResult("1");
        cepResponse.setComments("");
        cepResponse.setData("<![CDATA[<?xml version=\"1.0\"?>\n" +
                "<datacepresponse>\n" +
                "<row>\n" +
                "<document>*********</document>\n" +
                "<surname_latin>TEST</surname_latin>\n" +
                "<name_latin>TEST</name_latin>\n" +
                "<patronym_latin>TEST</patronym_latin>\n" +
                "<surname_engl/>\n" +
                "<name_engl/>\n" +
                "<birth_date>1988-06-05</birth_date>\n" +
                "<birth_place>TOSHKENT</birth_place>\n" +
                "<birth_place_id/>\n" +
                "<birth_country>ЎЗБЕКИСТОН</birth_country>\n" +
                "<birth_country_id>182</birth_country_id>\n" +
                "<livestatus>1</livestatus>\n" +
                "<nationality>ЎЗБЕК</nationality>\n" +
                "<nationality_id>44</nationality_id>\n" +
                "<citizenship>ЎЗБЕКИСТОН</citizenship>\n" +
                "<citizenship_id>182</citizenship_id>\n" +
                "<sex>1</sex>\n" +
                "<doc_give_place>ТОШКЕНТ ШАҲАР ЯККАСАРОЙ ТУМАНИ ИИБ</doc_give_place>\n" +
                "<doc_give_place_id>26287</doc_give_place_id>\n" +
                "<date_begin_document>2022-22-04</date_begin_document>\n" +
                "<date_end_document>2032-21-04</date_end_document>\n" +
                "</row>\n" +
                "</datacepresponse>]]>");

        return cepResponse;
    }


    public static String getCEPResponseStringXMl() {
        return "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <env:Header/>\n" +
                "    <env:Body>\n" +
                "        <GetDataByPinppResponse xmlns=\"http://fido.com/EasuEGServices\">\n" +
                "            <Result>1</Result>\n" +
                "            <Data>&lt;?xml version=\"1.0\"?>\n" +
                "&lt;personaldata>\n" +
                "&lt;row>\n" +
                "&lt;queryld>string&lt;/queryld>\n" +
                "&lt;pinpp>30606985630033&lt;/pinpp>\n" +
                "&lt;document>AB0557972&lt;/document>\n" +
                "&lt;surnamelatin>ZIYADULLAYEV&lt;/surnamelatin>\n" +
                "&lt;namelatin>AZAMAT&lt;/namelatin>\n" +
                "&lt;patronymlatin>XOLMUMIN O‘G‘LI&lt;/patronymlatin>\n" +
                "&lt;engsurname>ZIYADULLAEV&lt;/engsurname>\n" +
                "&lt;engname>AZAMAT&lt;/engname>\n" +
                "&lt;birth_date>1998-06-06&lt;/birth_date>\n" +
                "&lt;birthplace>QAMASHI TUMANI&lt;/birthplace>\n" +
                "&lt;birthplaceid/>\n" +
                "&lt;birthcountry>УЗБЕКИСТАН&lt;/birthcountry>\n" +
                "&lt;birthcountryid>182&lt;/birthcountryid>\n" +
                "&lt;livestatus>1&lt;/livestatus>\n" +
                "&lt;nationality>УЗБЕК/УЗБЕЧКА&lt;/nationality>\n" +
                "&lt;nationalityid>44&lt;/nationalityid>\n" +
                "&lt;citizenship>УЗБЕКИСТАН&lt;/citizenship>\n" +
                "&lt;citizenshipid>182&lt;/citizenshipid>\n" +
                "&lt;sex>1&lt;/sex>\n" +
                "&lt;docgiveplace>КАМАШИНСКИЙ РОВД КАШКАДАРЬИНСКОЙ ОБЛАСТИ&lt;/docgiveplace>\n" +
                "&lt;docgiveplaceid>10220&lt;/docgiveplaceid>\n" +
                "&lt;docdatebegin>2015-07-31&lt;/docdatebegin>\n" +
                "&lt;docdateend>2025-07-30&lt;/docdateend>\n" +
                "&lt;/row>\n" +
                "&lt;/personaldata></Data>\n" +
                "        <Comments/>\n" +
                "    </GetDataByPinppResponse>\n" +
                "</env:Body>\n" +
                "</env:Envelope>";
    }


    public static String GetDataByDocResponseStringXMl() {
        return "<?xml version='1.0' encoding='UTF-8'?><env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <env:Header/>\n" +
                "    <env:Body>\n" +
                "        <GetDataByDocResponse xmlns=\"http://fido.com/EasuEGServices\">\n" +
                "            <Result>1</Result>\n" +
                "            <Data>&lt;?xml version=\"1.0\"?>\n" +
                "&lt;personaldata>\n" +
                "&lt;row>\n" +
                "&lt;queryld>string&lt;/queryld>\n" +
                "&lt;pinpp>30606985630033&lt;/pinpp>\n" +
                "&lt;document>AB0557972&lt;/document>\n" +
                "&lt;surnamelatin>ZIYADULLAYEV&lt;/surnamelatin>\n" +
                "&lt;namelatin>AZAMAT&lt;/namelatin>\n" +
                "&lt;patronymlatin>XOLMUMIN O‘G‘LI&lt;/patronymlatin>\n" +
                "&lt;engsurname>ZIYADULLAEV&lt;/engsurname>\n" +
                "&lt;engname>AZAMAT&lt;/engname>\n" +
                "&lt;birth_date>1998-06-06&lt;/birth_date>\n" +
                "&lt;birthplace>QAMASHI TUMANI&lt;/birthplace>\n" +
                "&lt;birthplaceid/>\n" +
                "&lt;birthcountry>УЗБЕКИСТАН&lt;/birthcountry>\n" +
                "&lt;birthcountryid>182&lt;/birthcountryid>\n" +
                "&lt;livestatus>1&lt;/livestatus>\n" +
                "&lt;nationality>УЗБЕК/УЗБЕЧКА&lt;/nationality>\n" +
                "&lt;nationalityid>44&lt;/nationalityid>\n" +
                "&lt;citizenship>УЗБЕКИСТАН&lt;/citizenship>\n" +
                "&lt;citizenshipid>182&lt;/citizenshipid>\n" +
                "&lt;sex>1&lt;/sex>\n" +
                "&lt;docgiveplace>КАМАШИНСКИЙ РОВД КАШКАДАРЬИНСКОЙ ОБЛАСТИ&lt;/docgiveplace>\n" +
                "&lt;docgiveplaceid>10220&lt;/docgiveplaceid>\n" +
                "&lt;docdatebegin>2015-07-31&lt;/docdatebegin>\n" +
                "&lt;docdateend>2025-07-30&lt;/docdateend>\n" +
                "&lt;/row>\n" +
                "&lt;/personaldata></Data>\n" +
                "        <Comments/>\n" +
                "    </GetDataByDocResponse>\n" +
                "</env:Body>\n" +
                "</env:Envelope>";
    }


    public static String GetDataByDocResponseStringXMl2() {
        return "<?xml version='1.0' encoding='UTF-8'?><env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <env:Header/>\n" +
                "    <env:Body>\n" +
                "        <GetDataByDocResponse xmlns=\"http://fido.com/EasuEGServices\">\n" +
                "            <Result>4</Result>\n" +
                "            <Data/>\n" +
                "            <Comments/>\n" +
                "        </GetDataByDocResponse>\n" +
                "    </env:Body>\n" +
                "</env:Envelope>";
    }

    public static String getPersonAddressData1() {
        return "{\n" +
                "    \"Data\": {\n" +
                "        \"PermanentRegistration\": null,\n" +
                "        \"TemproaryRegistrations\": null\n" +
                "    },\n" +
                "    \"AnswereId\": 1,\n" +
                "    \"AnswereMessage\": \"Ok\",\n" +
                "    \"AnswereComment\": \"\"\n" +
                "}";
    }

    public static String getPersonAddressData2() {
        return "{\n" +
                "    \"AnswereId\": 5,\n" +
                "    \"AnswereMessage\": \"ЖШШР: 30410785050012 топилмади\",\n" +
                "    \"AnswereComment\": \"Берилган ЖШШР: 30410785050012 бўйича маълумотлар топилмади\"\n" +
                "}";
    }

    public static String getPersonAddressData() {
        return "{\n" +
                "  \"Data\": {\n" +
                "    \"PermanentRegistration\": {\n" +
                "      \"Cadastre\": \"10:04:06:03:02:5067:0001:024\",\n" +
                "      \"Country\": {\n" +
                "        \"Id\": 182,\n" +
                "        \"Value\": \"ЎЗБЕКИСТОН\",\n" +
                "        \"IdValue\": \"(182) ЎЗБЕКИСТОН\"\n" +
                "      },\n" +
                "      \"Region\": {\n" +
                "        \"Id\": 10,\n" +
                "        \"Value\": \"ТОШКЕНТ ШАҲРИ\",\n" +
                "        \"IdValue\": \"(10) ТОШКЕНТ ШАҲРИ\"\n" +
                "      },\n" +
                "      \"District\": {\n" +
                "        \"Id\": 739001080,\n" +
                "        \"Value\": \"ЯШНОБОД ТУМАНИ\",\n" +
                "        \"IdValue\": \"(739001080) ЯШНОБОД ТУМАНИ\"\n" +
                "      },\n" +
                "      \"Address\": \"Илтифот МФЙ, 58-Военный городок мавзеси, 45-уй, 24-хонадон\",\n" +
                "      \"RegistrationDate\": \"2022-12-29T00:00:00\"\n" +
                "    },\n" +
                "    \"TemproaryRegistrations\": [\n" +
                "      {\n" +
                "        \"Cadastre\": \"10:09:05:01:01:5295/14\",\n" +
                "        \"Country\": null,\n" +
                "        \"Region\": {\n" +
                "          \"Id\": 10,\n" +
                "          \"Value\": \"TOSHKENT SHAHRI\",\n" +
                "          \"IdValue\": \"(10) TOSHKENT SHAHRI\"\n" +
                "        },\n" +
                "        \"District\": {\n" +
                "          \"Id\": 1003,\n" +
                "          \"Value\": \"MIRZO ULUG‘BEK TUMANI\",\n" +
                "          \"IdValue\": \"(1003) MIRZO ULUG‘BEK TUMANI\"\n" +
                "        },\n" +
                "        \"Address\": \"ЯЛАНҒОЧ МФЙ, БУЮК ИПАК ЙУЛИ КЎЧАСИ,  uy:374/7А\",\n" +
                "        \"DateFrom\": \"2020-07-01T11:22:30\",\n" +
                "        \"DateTill\": \"2021-07-01T11:22:30\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"Cadastre\": \"10:09:05:01:01:5295/14\",\n" +
                "        \"Country\": null,\n" +
                "        \"Region\": {\n" +
                "          \"Id\": 10,\n" +
                "          \"Value\": \"TOSHKENT SHAHRI\",\n" +
                "          \"IdValue\": \"(10) TOSHKENT SHAHRI\"\n" +
                "        },\n" +
                "        \"District\": {\n" +
                "          \"Id\": 1003,\n" +
                "          \"Value\": \"MIRZO ULUG‘BEK TUMANI\",\n" +
                "          \"IdValue\": \"(1003) MIRZO ULUG‘BEK TUMANI\"\n" +
                "        },\n" +
                "        \"Address\": \"г. Ташкент, Мирзо Улугбекский район, ул. Буюк Ипак Йули, Ялангоч МСГ, 374/7а- Дом, -\",\n" +
                "        \"DateFrom\": \"2022-04-20T00:00:00\",\n" +
                "        \"DateTill\": \"2023-04-20T00:00:00\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"AnswereId\": 1,\n" +
                "  \"AnswereMessage\": \"Ok\",\n" +
                "  \"AnswereComment\": \"\"\n" +
                "}\n";
    }


    public static String getIndividualJson() {
        return "{\n" +
                "    \"document_type\": 1,\n" +
                "    \"passport_serial\": \"AD3957911\",\n" +
                "    \"firstname\": \"JAMILA\",\n" +
                "    \"lastname\": \"AMANBAEVA\",\n" +
                "    \"middlename\": \"MURATBAEVNA\",\n" +
                "    \"home_region\": null,\n" +
                "    \"home_subregion\": null,\n" +
                "    \"home_address\": null,\n" +
                "    \"registration_address_region_soato\": null,\n" +
                "    \"registration_address_sub_region_soato\": null,\n" +
                "    \"activity_region\": 1735,\n" +
                "    \"activity_subregion\": 1735401,\n" +
                "    \"activity_address\": \"JIPEK JOLI KO`CHASI 1-UY 6-MAGAZIN  \",\n" +
                "    \"activity_type_id\": 9,\n" +
                "    \"activity_type_name_uz\": \"Oziq-ovqat va nooziq-ovqat tovarlari bilan chakana savdo qilish (qurilish materiallari, sement, shifer, yog‘och va yog‘och mahsulotlari, alkogolli va tamaki mahsulotlari, neft mahsulotlarining barcha turlari, qimmatbaho metallar va qimmatbaho toshlardan yasalgan buyumlar yoxud bunday materiallar qo‘llanilgan buyumlar, audiovizual asarlar, fonogrammalar va EHM uchun yaratilgan dasturlar, yangi import avtomobillar, farmatsevtika tovarlarini sotish bundan mustasno)\",\n" +
                "    \"pin\": \"40407883500025\",\n" +
                "    \"official_registration_date\": \"06.07.2021\",\n" +
                "    \"certificate_number\": \"1423418\",\n" +
                "    \"registry_number\": \"1423418\",\n" +
                "    \"active_till\": \"\"\n" +
                "}\n";
    }


    public static String getLegalJson() {
        return "{\n" +
                "    \"name\": \"\\\"TEST UCHUN\\\" Xususiy korxona\",\n" +
                "    \"shortname\": \"\\\"TEST UCHUN\\\" XK\",\n" +
                "    \"le_status\": 0,\n" +
                "    \"official_registration_date\": \"12.01.2010\",\n" +
                "    \"certificate_number\": \"1\",\n" +
                "    \"registry_number\": \"1\",\n" +
                "    \"tin\": 123456789,\n" +
                "    \"opf\": 110,\n" +
                "    \"home_region\": null,\n" +
                "    \"home_subregion\": null,\n" +
                "    \"home_address\": null\n" +
                "}";
    }


    public static String getPassportDataJson() {
        return "{\n" +
                "    \"result\": \"1\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"transaction_id\": 115230,\n" +
                "            \"current_pinpp\": \"32605900261179\",\n" +
                "            \"pinpps\": [\n" +
                "                \"32605900261679\"\n" +
                "            ],\n" +
                "            \"current_document\": \"AA9001140\",\n" +
                "            \"documents\": [\n" +
                "                {\n" +
                "                    \"document\": \"FA7483369\",\n" +
                "                    \"type\": \"IDMS_RECV_IP_DOCUMENTS\",\n" +
                "                    \"docgiveplace\": \"ЧИЛАНЗАРСКИЙ РУВД ГОРОДА ТАШКЕНТА\",\n" +
                "                    \"docgiveplaceid\": 26294,\n" +
                "                    \"datebegin\": \"2023-03-29\",\n" +
                "                    \"dateend\": \"2033-03-28\",\n" +
                "                    \"status\": 2\n" +
                "                },\n" +
                "                {\n" +
                "                    \"document\": \"AA9001140\",\n" +
                "                    \"type\": \"IDMS_RECV_CITIZ_DOCUMENTS\",\n" +
                "                    \"docgiveplace\": \"ЧИЛАНЗАРСКИЙ РУВД ГОРОДА ТАШКЕНТА\",\n" +
                "                    \"docgiveplaceid\": 26294,\n" +
                "                    \"datebegin\": \"2015-03-13\",\n" +
                "                    \"dateend\": \"2025-03-12\",\n" +
                "                    \"status\": 2\n" +
                "                }\n" +
                "            ],\n" +
                "            \"surnamelat\": \"ESHAMTOV\",\n" +
                "            \"namelat\": \"QO'QONBOY\",\n" +
                "            \"patronymlat\": \"TOSHMAT o'g'li\",\n" +
                "            \"surnamecyr\": \"Ешматов\",\n" +
                "            \"namecyr\": \"Қўқонбой\",\n" +
                "            \"patronymcyr\": \"Тошмат Ўғли\",\n" +
                "            \"engsurname\": \"Eshmatov\",\n" +
                "            \"engname\": \"Qo'qonboy\",\n" +
                "            \"birth_date\": \"1991-01-01\",\n" +
                "            \"birthplace\": null,\n" +
                "            \"birthcountry\": \"УЗБЕКИСТАН\",\n" +
                "            \"birthcountryid\": 182,\n" +
                "            \"livestatus\": 1,\n" +
                "            \"nationality\": \"УЗБЕК/УЗБЕЧКА\",\n" +
                "            \"nationalityid\": 44,\n" +
                "            \"citizenship\": \"УЗБЕКИСТАН\",\n" +
                "            \"citizenshipid\": 182,\n" +
                "            \"sex\": 1\n" +
                "        }\n" +
                "    ],\n" +
                "    \"comments\": \"\"\n" +
                "}\n";

        //  Тошмат Ўғли
    }


  public static String getPassportDataJson2() {
        return "{\n" +
                "\t\"result\": \"1\",\n" +
                "\t\"data\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"transaction_id\": 3,\n" +
                "\t\t\t\"current_pinpp\": \"51012076020026\",\n" +
                "\t\t\t\"pinpps\": [\n" +
                "\t\t\t\t\"51012076020026\",\n" +
                "\t\t\t\t\"51012076020019\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"current_document\": null,\n" +
                "\t\t\t\"documents\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"document\": \"AD5405767\",\n" +
                "\t\t\t\t\t\"type\": \"IDMS_RECV_MVD_IDCARD_CITIZEN\",\n" +
                "\t\t\t\t\t\"docgiveplace\": \"АКДАРЬИНСКИЙ РОВД САМАРКАНДСКОЙ ОБЛАСТИ\",\n" +
                "\t\t\t\t\t\"docgiveplaceid\": 18203,\n" +
                "\t\t\t\t\t\"datebegin\": \"2023-12-13\",\n" +
                "\t\t\t\t\t\"dateend\": \"2033-12-12\",\n" +
                "\t\t\t\t\t\"status\": 2\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"document\": \"I-SM0284046\",\n" +
                "\t\t\t\t\t\"type\": \"IDMS_RECV_MJ_BIRTH_CERTS\",\n" +
                "\t\t\t\t\t\"docgiveplace\": \"ОТДЕЛ ЗАГС АКДАРЬИНСКОГО РАЙОНА\",\n" +
                "\t\t\t\t\t\"docgiveplaceid\": 1407,\n" +
                "\t\t\t\t\t\"datebegin\": \"2007-12-13\",\n" +
                "\t\t\t\t\t\"dateend\": null,\n" +
                "\t\t\t\t\t\"status\": 4\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"surnamelat\": \"SAYDULLAYEV\",\n" +
                "\t\t\t\"namelat\": \"BAXODIR\",\n" +
                "\t\t\t\"patronymlat\": \"JASUR O‘G‘LI\",\n" +
                "\t\t\t\"birth_date\": \"2007-12-10\",\n" +
                "\t\t\t\"birthplace\": \"OQDARYO TUMANI\",\n" +
                "\t\t\t\"birthcountry\": \"УЗБЕКИСТАН\",\n" +
                "\t\t\t\"birthcountryid\": 182,\n" +
                "\t\t\t\"livestatus\": 1,\n" +
                "\t\t\t\"nationality\": \"УЗБЕК/УЗБЕЧКА\",\n" +
                "\t\t\t\"nationalityid\": 44,\n" +
                "\t\t\t\"citizenship\": \"УЗБЕКИСТАН\",\n" +
                "\t\t\t\"citizenshipid\": 182,\n" +
                "\t\t\t\"sex\": 1\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"comments\": \"\"\n" +
                "}";

        //  Тошмат Ўғли
    }


    public static String getCreditReportKATM() {
        return "{\n" +
                "    \"data\": {\n" +
                "        \"result\": \"05050\",\n" +
                "        \"resultMessage\": \"The report awaits confirmation by the operator\",\n" +
                "        \"reportBase64\": null,\n" +
                "        \"token\": \"tpyehkaoezqjlqyotcgbqtylmtfopmgk\"\n" +
                "    },\n" +
                "    \"errorMessage\": null,\n" +
                "    \"code\": 200\n" +
                "}";
    }


    public static String getCreditReportKATMError() {
        return "{\n" +
                "  \"data\": null,\n" +
                "  \"errorMessage\": \"pReason: Поле должно содержать только цифры 0-9, pActivity: Поле должно содержать только цифры 0-9\",\n" +
                "  \"code\": 500\n" +
                "}";
    }


    public static String getEisvoResponse() {
        return "{\n" +
                "  \"status\": 0,\n" +
                "  \"errorMsg\": \"OK\",\n" +
                "  \"timeStamp\": \"2024-04-01T10:07:32.432+00:00\",\n" +
                "  \"gtkId\": 1711966052418,\n" +
                "  \"contract\": {\n" +
                "    \"idn\": \"200242936303896172249800002\",\n" +
                "    \"rootIdn\": null,\n" +
                "    \"cntrType\": \"98\",\n" +
                "    \"oldIdn\": null,\n" +
                "    \"bankId\": \"11432\",\n" +
                "    \"mvesNo\": null,\n" +
                "    \"mvesDate\": null,\n" +
                "    \"govDcsnNo\": null,\n" +
                "    \"govDcsnDate\": null,\n" +
                "    \"okpo\": \"        \",\n" +
                "    \"okonx\": \"01.13.1\",\n" +
                "    \"contractorUzParentCompany\": null,\n" +
                "    \"contractorUzName\": \"SAVLATSHOX SAVDO SERVIS LLC\",\n" +
                "    \"rgnCode\": \"18\",\n" +
                "    \"industrialZoneCode\": 0,\n" +
                "    \"contractorUzAddress\": \"Republic of Uzbekistan, Samarkand region, Akdarya district, Uzbekistan st.\",\n" +
                "    \"contractorUzPhone\": \"--\",\n" +
                "    \"cntrSubject\": 1,\n" +
                "    \"currCode1\": null,\n" +
                "    \"currCode2\": null,\n" +
                "    \"amount1\": null,\n" +
                "    \"amount2\": null,\n" +
                "    \"accCurrCode1\": null,\n" +
                "    \"accCurrCode2\": null,\n" +
                "    \"contractorForName\": null,\n" +
                "    \"contractorForCountryCode\": null,\n" +
                "    \"contractorForAddress\": null,\n" +
                "    \"bankForName\": null,\n" +
                "    \"bankForCountryCode\": null,\n" +
                "    \"bankForAddress\": null,\n" +
                "    \"bankForAttributes\": null,\n" +
                "    \"centralBankLetterNo\": null,\n" +
                "    \"centralBankLetterDate\": null,\n" +
                "    \"creditRate\": null,\n" +
                "    \"leasingFlag\": null,\n" +
                "    \"productsName\": \"ГРЕЦКИЙ ОРЕХ\",\n" +
                "    \"docNo\": \"2\",\n" +
                "    \"docDate\": \"2024-03-29\",\n" +
                "    \"execType\": null,\n" +
                "    \"execDate\": null,\n" +
                "    \"reestrRegNo\": null,\n" +
                "    \"softwareName\": null,\n" +
                "    \"cntrStatus\": 0,\n" +
                "    \"lockDate\": null,\n" +
                "    \"status\": 0,\n" +
                "    \"cstDate\": null,\n" +
                "    \"contractorUzInn\": \"303896172\",\n" +
                "    \"receivableTotal1\": 0,\n" +
                "    \"receivableOverdue1\": 0,\n" +
                "    \"receivableTotal2\": 0,\n" +
                "    \"receivableOverdue2\": 0,\n" +
                "    \"payableTotal1\": 0,\n" +
                "    \"payableOverdue1\": 0,\n" +
                "    \"payableTotal2\": 0,\n" +
                "    \"payableOverdue2\": 0,\n" +
                "    \"insTime\": \"2024-03-29T10:37:24.796+00:00\",\n" +
                "    \"specifications\": [\n" +
                "      {\n" +
                "        \"docDate\": \"2024-03-29\",\n" +
                "        \"amount\": null,\n" +
                "        \"agrmNo\": null,\n" +
                "        \"currCode\": null,\n" +
                "        \"cstDate\": null,\n" +
                "        \"docType\": 0,\n" +
                "        \"docNo\": \"0\",\n" +
                "        \"imExFlag\": 1,\n" +
                "        \"serialNo\": 1,\n" +
                "        \"insTime\": \"2024-03-29T10:37:24.805+00:00\",\n" +
                "        \"oldNo\": null,\n" +
                "        \"status\": 0,\n" +
                "        \"confirmations\": [],\n" +
                "        \"goods\": [\n" +
                "          {\n" +
                "            \"tnCode\": \"0802310000\",\n" +
                "            \"itemsName\": \"ГРЕЦКИЙ ОРЕХ\",\n" +
                "            \"serialNo\": 1,\n" +
                "            \"unitCode\": null,\n" +
                "            \"quantity\": \"0.0\",\n" +
                "            \"currCode\": \"0\",\n" +
                "            \"cost\": \"0.0\",\n" +
                "            \"amount\": \"0.0\",\n" +
                "            \"insTime\": \"2024-03-29T10:37:24.808+00:00\",\n" +
                "            \"status\": 0\n" +
                "          }\n" +
                "        ],\n" +
                "        \"fare\": null,\n" +
                "        \"services\": []\n" +
                "      },\n" +
                "      {\n" +
                "        \"docDate\": \"2024-03-29\",\n" +
                "        \"amount\": null,\n" +
                "        \"agrmNo\": null,\n" +
                "        \"currCode\": null,\n" +
                "        \"cstDate\": null,\n" +
                "        \"docType\": 0,\n" +
                "        \"docNo\": \"0\",\n" +
                "        \"imExFlag\": 0,\n" +
                "        \"serialNo\": 2,\n" +
                "        \"insTime\": \"2024-03-29T10:37:24.812+00:00\",\n" +
                "        \"oldNo\": null,\n" +
                "        \"status\": 0,\n" +
                "        \"confirmations\": [],\n" +
                "        \"goods\": [\n" +
                "          {\n" +
                "            \"tnCode\": \"0802320000\",\n" +
                "            \"itemsName\": \"ГРЕЦКИЙ ОРЕХ\",\n" +
                "            \"serialNo\": 1,\n" +
                "            \"unitCode\": null,\n" +
                "            \"quantity\": \"0.0\",\n" +
                "            \"currCode\": \"0\",\n" +
                "            \"cost\": \"0.0\",\n" +
                "            \"amount\": \"0.0\",\n" +
                "            \"insTime\": \"2024-03-29T10:37:24.817+00:00\",\n" +
                "            \"status\": 0\n" +
                "          }\n" +
                "        ],\n" +
                "        \"fare\": null,\n" +
                "        \"services\": []\n" +
                "      }\n" +
                "    ],\n" +
                "    \"performedServices\": [],\n" +
                "    \"consignors\": [],\n" +
                "    \"consignees\": [],\n" +
                "    \"manufacturers\": [],\n" +
                "    \"deliveryTerms\": [],\n" +
                "    \"financeInfos\": [],\n" +
                "    \"agreements\": [],\n" +
                "    \"endContract\": null,\n" +
                "    \"exportTerms\": [],\n" +
                "    \"internalShipments\": null,\n" +
                "    \"tollingTerms\": [],\n" +
                "    \"importTerms\": [],\n" +
                "    \"barterTerms\": [],\n" +
                "    \"transfers\": [],\n" +
                "    \"delegates\": [],\n" +
                "    \"declarations\": [],\n" +
                "    \"guarantees\": [],\n" +
                "    \"lettersOfCredit\": [],\n" +
                "    \"policies\": [],\n" +
                "    \"receivableDrops\": [],\n" +
                "    \"payableDrops\": [],\n" +
                "    \"penalties\": [],\n" +
                "    \"commissions\": [],\n" +
                "    \"taxAgencyPenalties\": [],\n" +
                "    \"receivableInfos\": [],\n" +
                "    \"funds\": [],\n" +
                "    \"refundsExp\": [],\n" +
                "    \"movesToEx\": [],\n" +
                "    \"movesFromEx\": [],\n" +
                "    \"paymentRefs\": [],\n" +
                "    \"taxes\": [],\n" +
                "    \"compensations\": [],\n" +
                "    \"sales\": [],\n" +
                "    \"leasePayments\": [],\n" +
                "    \"payments\": [],\n" +
                "    \"refundsImp\": [],\n" +
                "    \"movesToIm\": [],\n" +
                "    \"movesFromIm\": [],\n" +
                "    \"exchangePayments\": []\n" +
                "  }\n" +
                "}";
    }


    public static String getOrgInfoSystemResponse() {
        return "{\n" +
                "    \"INFO DATE\": \"2024-04-08 17:23:26\",\n" +
                "    \"INN\": \"201838002\",\n" +
                "    \"OKPO\": \"16174825\",\n" +
                "    \"REG_NOM\": \"292\",\n" +
                "    \"REG_DATA\": \"1999-12-11\",\n" +
                "    \"SOOGU\": \"79994\",\n" +
                "    \"SOATO\": \"1726273\",\n" +
                "    \"NAME\": \"\\\"UNITEL\\\" mas`uliyati cheklangan jamiyati xorijiy korxonasi\",\n" +
                "    \"NAME_S\": \"\\\"UNITEL\\\" MChJ XK\",\n" +
                "    \"ADRES\": \"Toshkent shahri, Mirobod tumani\",\n" +
                "    \"STREET\": \"Banokatiy MFY, Buxoro ko`chasi, 1-uy\",\n" +
                "    \"PHONE\": \"903730330\",\n" +
                "    \"EMAIL\": \"0611@BEELINE.UZ\",\n" +
                "    \"OPF\": \"152\",\n" +
                "    \"CSDP\": \"11\",\n" +
                "    \"OKED\": \"61200\",\n" +
                "    \"OKSM_1\": \"528\",\n" +
                "    \"NAMU_1\": \"VEON Uzbekistan Holding B.V.\",\n" +
                "    \"OKSM_2\": \"528\",\n" +
                "    \"NAMU_2\": \"VEON Central Asia B.V.\",\n" +
                "    \"OKSM_3\": \"\",\n" +
                "    \"NAMU_3\": \"\",\n" +
                "    \"OKSM_4\": \"\",\n" +
                "    \"NAMU_4\": \"\",\n" +
                "    \"OKSM_5\": \"\",\n" +
                "    \"NAMU_5\": \"\",\n" +
                "    \"UF_1\": \"244271513.2477\",\n" +
                "    \"DOL_1\": \"70.0000\",\n" +
                "    \"UF_2\": \"104687791.3919\",\n" +
                "    \"DOL_2\": \"30.0000\",\n" +
                "    \"UF_3\": \"\",\n" +
                "    \"DOL_3\": \"\",\n" +
                "    \"UF_4\": \"\",\n" +
                "    \"DOL_4\": \"\",\n" +
                "    \"UF_5\": \"\",\n" +
                "    \"DOL_5\": \"\",\n" +
                "    \"DIRECTOR\": \"ANDRZEJ EDWARD MALINOWSKI XXX\"\n" +
                "}";
    }


    public static String getOrgInfoSystemResponseError() {

        return "{\n" +
                "    \"result_code\": \"2\",\n" +
                "    \"result_message\": \"Ushbu stir bilan korxona topilmadi\"\n" +
                "}";

    }

    public static String getAgreementResponseJsonStr() {

        return "{\n" +
                "  \"query_id\": \"24205000000000142800\",\n" +
                "  \"code\": \"15000\",\n" +
                "  \"message\": \"Успешно\",\n" +
                "  \"opened\": \"22.12.2023\",\n" +
                "  \"state\": \"01\",\n" +
                "  \"closed\": \"\",\n" +
                "  \"bank\": \"067\",\n" +
                "  \"contract\": {\n" +
                "    \"id\": \"2023309279057203125001\",\n" +
                "    \"ex_id\": \"2023309279057203125001\",\n" +
                "    \"number\": \"095/2023\",\n" +
                "    \"debt_type\": \"02\",\n" +
                "    \"credit_type\": \"02\",\n" +
                "    \"debt_kind\": \"03\",\n" +
                "    \"date\": \"14.07.2023\",\n" +
                "    \"debt_sum\": \"\",\n" +
                "    \"debt_ pct\": \"\",\n" +
                "    \"contract_sum\": {\n" +
                "      \"sum\": 132811548.2,\n" +
                "      \"currency\": \"156\",\n" +
                "      \"currency_debt\": \"156\",\n" +
                "      \"currency_pct\": \"156\"\n" +
                "    },\n" +
                "    \"float_pct\": {\n" +
                "      \"type_pct\": \"\",\n" +
                "      \"margin\": \"\"\n" +
                "    },\n" +
                "    \"fix_sum\": null,\n" +
                "    \"fix_pct\": \"5.9\",\n" +
                "    \"term\": \"12\",\n" +
                "    \"first_term\": \"12\",\n" +
                "    \"target\": \"Куёш станцияси куриш\",\n" +
                "    \"doc_number\": \"3166-09\",\n" +
                "    \"doc_date\": \"22.12.2023\",\n" +
                "    \"period_debt\": \"01\",\n" +
                "    \"period_pct\": \"01\",\n" +
                "    \"creditor\": {\n" +
                "      \"name\": \"ГПБ Комплект АЖ\",\n" +
                "      \"country\": \"643\",\n" +
                "      \"foreign_org\": \"03\",\n" +
                "      \"uzb_org\": \"\",\n" +
                "      \"inn\": \"\",\n" +
                "      \"region\": \"\",\n" +
                "      \"oked\": \"\",\n" +
                "      \"state_sector\": \"\",\n" +
                "      \"sector\": \"\",\n" +
                "      \"economy\": \"\",\n" +
                "      \"attitude\": \"\"\n" +
                "    },\n" +
                "    \"loan\": {\n" +
                "      \"name\": \"KHONOBOD SOLAR ENERGY\",\n" +
                "      \"country\": \"\",\n" +
                "      \"foreign_org\": \"\",\n" +
                "      \"uzb_org\": \"03\",\n" +
                "      \"inn\": \"309279057\",\n" +
                "      \"region\": \"26\",\n" +
                "      \"oked\": \"35119\",\n" +
                "      \"state_sector\": \"01\",\n" +
                "      \"sector\": \"09\",\n" +
                "      \"economy\": \"01\",\n" +
                "      \"attitude\": \"04\"\n" +
                "    },\n" +
                "    \"admission\": [\n" +
                "      {\n" +
                "        \"year\": \"2023\",\n" +
                "        \"first\": 0,\n" +
                "        \"second\": 0,\n" +
                "        \"third\": 0,\n" +
                "        \"fourth\": 0\n" +
                "      }\n" +
                "    ],\n" +
                "    \"repayment\": [\n" +
                "      {\n" +
                "        \"year\": \"2023\",\n" +
                "        \"first\": 0,\n" +
                "        \"second\": 0,\n" +
                "        \"third\": 0,\n" +
                "        \"fourth\": 0\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

    }


    }
