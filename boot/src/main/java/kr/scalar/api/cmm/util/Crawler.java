package kr.scalar.api.cmm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class reviewer {@Override public String toString() {
				return "<"+pceNum+">"+revStar+", "+revName+ ", " 
					  	             +revContent+", "+revDate;}
	String revStar; String revName; String revContent; String revDate; String pceNum;
	
	public reviewer(
			 String revStar, String revName, 
			 String revContent, String revDate, String pceNum){
		super();
		this.revStar = revStar;
		this.revName = revName;
		this.revContent = revContent;
		this.revDate = revDate;
		this.pceNum = pceNum;}
	
	public String getRevStar() {return revStar;}
	public void setRevStar(String revStar) {this.revStar = revStar;}
	public String getRevName() {return revName;}
	public void setRevName(String revName) {this.revName = revName;}
	public String getRevContent() {return revContent;}
	public void setRevContent(String revContent) {this.revContent = revContent;}
	public String getRevDate() {return revDate;}
	public void setRevDate(String revDate) {this.revDate = revDate;}
	public String getPceNum() {return pceNum;}
	public void setPceNum(String pceNum) {this.pceNum = pceNum;}}

public class Crawler {
	public static List<reviewer> placeAutoUrl(List<reviewer> revList, ChromeDriver driver, String url, String number){
		Logger logger = LoggerFactory.getLogger(Crawler.class);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement rev = driver.findElementByClassName("list_evaluation");
		List<WebElement> ls = rev.findElements(By.cssSelector("li"));
		
		for(int i=0;i<ls.size();i++) {
			String revName = ls.get(i).findElement(By.className("link_user")).getText();
			String revContent = ls.get(i).findElement(By.className("txt_comment")).getText();
			String revStar = ls.get(i).findElement(By.className("num_rate")).getText();
			String revDate = ls.get(i).findElement(By.className("time_write")).getText();
			revList.add(new reviewer(revStar,revName,revContent,revDate,number));
			logger.info(revList.get(revList.size()-1).toString());}
		return revList;}
	
	/*(????????????) 6,???????? ?????? ??? ?????? ?????? ???????????? ???????????????
	   	       7,???????? ??? ????????? ???????????? 
	   	       24. ??????????????? ?????? ?????? ??????
	   	       47. ?????? ????????????
	   	       62.?????????????????????????? ????????? ?????????
	   	       65. ????????????????????? ????????????
	   	       75.???????? ????????????????????? 2021
	   	       76. ?????? ?????????????????? (???????????? ???????????????)
	   	       81.?????????????????????????? ???????????????
	   	       89.?????????????? ?????????
	   	       90.??????????? ???????????? ????????? ????????? ??????
	   	       93.?????????????????
	   	       126. ??????????????? ?????????
	   	       130. ????????? ?????? ?????? ????????? ????????? ????????? ?????? [??????]
	   	       135.???????? ?????? ????????? ???????????? ??????
	   	       140.????????????????????
	   	       148.??????????? ????????? */
	   	       
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String reviewURL = "https://place.map.kakao.com/";
		List<reviewer> revList = new ArrayList<>();

			
		placeAutoUrl(revList, driver,reviewURL+"21449945","1");      //????????????
		placeAutoUrl(revList, driver,reviewURL+"19125965","2");      //???????????????
		placeAutoUrl(revList, driver,reviewURL+"10924317","3");      //???????????????
		placeAutoUrl(revList, driver,reviewURL+"25622898","4");      //88????????????
		placeAutoUrl(revList, driver,reviewURL+"1903622145","5");    //YAT(???????????????)
																    	      //????????????(6,7)
		placeAutoUrl(revList, driver,reviewURL+"10116103","8");      //???????????????
		placeAutoUrl(revList, driver,reviewURL+"8141879","9");       //???????????? ???????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"11041736","10");     //?????????
		placeAutoUrl(revList, driver,reviewURL+"8201549","11");      //????????????
		placeAutoUrl(revList, driver,reviewURL+"25625906","12");     //?????????????????????
		placeAutoUrl(revList, driver,reviewURL+"8216097","13");      //?????????????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"1364813679","14");   //?????????????????????
		placeAutoUrl(revList, driver,reviewURL+"8206191","15");      //?????????
		placeAutoUrl(revList, driver,reviewURL+"11891822","16");     //????????????
		placeAutoUrl(revList, driver,reviewURL+"8250511","17");      //????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"20089686","18");     //???????????????????????????
		placeAutoUrl(revList, driver,reviewURL+"1618971940","19");   //???????????? ?????????
		placeAutoUrl(revList, driver,reviewURL+"9703855","20");      //????????????
		placeAutoUrl(revList, driver,reviewURL+"9697792","21");      //????????????
		placeAutoUrl(revList, driver,reviewURL+"21814112","22");     //????????????
		placeAutoUrl(revList, driver,reviewURL+"10324177","23");     //?????????
																		      //????????????(24)
		placeAutoUrl(revList, driver,reviewURL+"315908155","25");    //??? ?????? ?????????
		placeAutoUrl(revList, driver,reviewURL+"27010613","26");     //???????????????
		placeAutoUrl(revList, driver,reviewURL+"12656758","27");     //????????????
		placeAutoUrl(revList, driver,reviewURL+"1123919078","28");   //?????????????????????
		placeAutoUrl(revList, driver,reviewURL+"7843350","29");      //?????????
		placeAutoUrl(revList, driver,reviewURL+"11892233","30");     //???????????????
		placeAutoUrl(revList, driver,reviewURL+"10364864","31");     //????????????
		placeAutoUrl(revList, driver,reviewURL+"7851701","32");      //????????????
		placeAutoUrl(revList, driver,reviewURL+"27392264","33");     //??????????????? ??????
		placeAutoUrl(revList, driver,reviewURL+"8998463","34");      //????????????
		placeAutoUrl(revList, driver,reviewURL+"11248590","35");     //???????????????
		placeAutoUrl(revList, driver,reviewURL+"20706973","36");     //???????????????
		placeAutoUrl(revList, driver,reviewURL+"26035534","37");     //???????????????????????????
		placeAutoUrl(revList, driver,reviewURL+"14749593","38");     //???????????? ?????? ???????????? ?????????
		placeAutoUrl(revList, driver,reviewURL+"11305083","39");     //?????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"1364813679","40");   //?????? ???????????????
		placeAutoUrl(revList, driver,reviewURL+"10455856","41");     //????????????????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"7902860","42");      //????????????
		placeAutoUrl(revList, driver,reviewURL+"7904044","43");      //?????????
		placeAutoUrl(revList, driver,reviewURL+"8340024","44");      //?????????
		placeAutoUrl(revList, driver,reviewURL+"853690564","45");    //?????????????????????
		placeAutoUrl(revList, driver,reviewURL+"7951458","46");      //????????????????????????
																		      //????????????(47)
		placeAutoUrl(revList, driver,reviewURL+"23256180","48");     //?????? ?????????
		placeAutoUrl(revList, driver,reviewURL+"7949134","49");      //?????? ????????????
		placeAutoUrl(revList, driver,reviewURL+"12664858","50");     //?????? ??????????????? ????????????
		placeAutoUrl(revList, driver,reviewURL+"11134307","51");     //?????? ????????????
		placeAutoUrl(revList, driver,reviewURL+"8693759","52");      //?????????????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"21054684","53");     //??????????????????
		placeAutoUrl(revList, driver,reviewURL+"17721245","54");     //??????????????????
		placeAutoUrl(revList, driver,reviewURL+"8216362","55");      //????????? ?????????
		placeAutoUrl(revList, driver,reviewURL+"8036325","56");	     //????????? ????????????
		placeAutoUrl(revList, driver,reviewURL+"24414762","57");	 //????????? ???????????????
		placeAutoUrl(revList, driver,reviewURL+"8375070","58");      //????????? ???????????????
		placeAutoUrl(revList, driver,reviewURL+"7944159","59");	     //?????????????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"21054684","60");     //????????????????????? ??????????????????
		placeAutoUrl(revList, driver,reviewURL+"15147983","61");     //?????????????????????(?????????)
																			  //????????????(62)
		placeAutoUrl(revList, driver,reviewURL+"26290244","63");     //??????????????????
		placeAutoUrl(revList, driver,reviewURL+"9168616","64");      //????????????????????????
																			  //????????????(65)
//??????x	placeAutoUrl(revList, driver,reviewURL+"10494265","66");     //?????????????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"7939479","67");      //??????????????????????????????
		placeAutoUrl(revList, driver,reviewURL+"1327493089","68");   //???????????????
		placeAutoUrl(revList, driver,reviewURL+"7952590","69");      //?????? ???????????????
		placeAutoUrl(revList, driver,reviewURL+"649182629","70");    //?????? ????????????   		
//??????x	placeAutoUrl(revList, driver,reviewURL+"8376588","71");      //?????????????????????
		placeAutoUrl(revList, driver,reviewURL+"27351432","72");     //???????????? ??????(Alive Heart)
		placeAutoUrl(revList, driver,reviewURL+"12697671","73");     //???????????????
		placeAutoUrl(revList, driver,reviewURL+"1970947390","74");   //????????? ???????????????
																		      //????????????(75)
																			  //????????????(76)
		placeAutoUrl(revList, driver,reviewURL+"8065637","77");      //?????? ????????? ??????
		placeAutoUrl(revList, driver,reviewURL+"19304774","78");     //?????? ??????????????? ??????,
		placeAutoUrl(revList, driver,reviewURL+"1970947390","79");   //????????? ???????????????
		placeAutoUrl(revList, driver,reviewURL+"12797187","80");     //????????????????????????
																		      //????????????(81)
		placeAutoUrl(revList, driver,reviewURL+"7952759","82");      //???????????????
		placeAutoUrl(revList, driver,reviewURL+"10543534","83");     //??????????????????			
//??????x	placeAutoUrl(revList, driver,reviewURL+"374570243","84");    //?????????????????????
		placeAutoUrl(revList, driver,reviewURL+"24751102","85");     //??????????????????
		placeAutoUrl(revList, driver,reviewURL+"9158247","86");      //?????????????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"371169740","88");    //????????????????????????
																			  //????????????(89)
																		      //????????????(90)
		placeAutoUrl(revList, driver,reviewURL+"7958898","91");      //?????????
		placeAutoUrl(revList, driver,reviewURL+"22099937","92");     //????????????
																		      //????????????(93)
		placeAutoUrl(revList, driver,reviewURL+"1311816688","94");   //????????????
		placeAutoUrl(revList, driver,reviewURL+"19947943","95");     //?????????????????????
		placeAutoUrl(revList, driver,reviewURL+"11126744","96");     //????????????
		placeAutoUrl(revList, driver,reviewURL+"797562421","97");    //??????????????????
		placeAutoUrl(revList, driver,reviewURL+"10543253","98");     //?????????????????????
		placeAutoUrl(revList, driver,reviewURL+"10532834","99");     //???????????????		
//??????x	placeAutoUrl(revList, driver,reviewURL+"11435044","100");    //???????????? ??????
		placeAutoUrl(revList, driver,reviewURL+"1098447501","101");  //???????????????     
		placeAutoUrl(revList, driver,reviewURL+"1098447501","102");  //???????????????
		placeAutoUrl(revList, driver,reviewURL+"7993485","103"); 	 //???????????????
		placeAutoUrl(revList, driver,reviewURL+"11495403","104");    //??????????????? ??????
		placeAutoUrl(revList, driver,reviewURL+"11951680","105");    //???????????????
		placeAutoUrl(revList, driver,reviewURL+"19624242","106");    //????????????9
		placeAutoUrl(revList, driver,reviewURL+"978709031","107");   //?????????????????????
		placeAutoUrl(revList, driver,reviewURL+"7994126","108");     //???????????????
		placeAutoUrl(revList, driver,reviewURL+"24857116","109");    //???????????????
		placeAutoUrl(revList, driver,reviewURL+"7999903","110");     //?????????           	  
//??????x	placeAutoUrl(revList, driver,reviewURL+"8011765","111");     //????????? ????????? ??????????????????
		placeAutoUrl(revList, driver,reviewURL+"8008145","112");     //?????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"10650417","113");    //??????????????????
		placeAutoUrl(revList, driver,reviewURL+"24451703","114");    //??????????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"10633799","115");    //???????????????
		placeAutoUrl(revList, driver,reviewURL+"9267011","116");     //????????????????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"9293198","117");     //????????????
		placeAutoUrl(revList, driver,reviewURL+"632257610","118");   //???????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"8021355","119");     //????????????
		placeAutoUrl(revList, driver,reviewURL+"8016468","120");     //???????????????
		placeAutoUrl(revList, driver,reviewURL+"9366982","121");     //???????????????
		placeAutoUrl(revList, driver,reviewURL+"1131080213","122");  //?????????			
//??????x	placeAutoUrl(revList, driver,reviewURL+"10688023","123");    //????????????
		placeAutoUrl(revList, driver,reviewURL+"24267521","124");    //???????????????
		placeAutoUrl(revList, driver,reviewURL+"13606733","125");    //????????????
																			  //????????????(126)
		placeAutoUrl(revList, driver,reviewURL+"10737561","127");    //?????????
		placeAutoUrl(revList, driver,reviewURL+"11441632","128");    //???????????????
		placeAutoUrl(revList, driver,reviewURL+"21345651","129");    //???????????????????????????
																		      //????????????(130)
		placeAutoUrl(revList, driver,reviewURL+"11170136","131");    //????????????????????????
		placeAutoUrl(revList, driver,reviewURL+"13320662","132");	  //???????????????
		placeAutoUrl(revList, driver,reviewURL+"9395122","133");     //????????????
		placeAutoUrl(revList, driver,reviewURL+"18682831","134");    //????????????
																			  //????????????(135)
		placeAutoUrl(revList, driver,reviewURL+"8086528","136");  	  //????????????
		placeAutoUrl(revList, driver,reviewURL+"10763109","137");    //????????????????????????
		placeAutoUrl(revList, driver,reviewURL+"8086427","138");     //????????????
		placeAutoUrl(revList, driver,reviewURL+"8092408","139");     //???????????????
																			  //????????????(140)
		placeAutoUrl(revList, driver,reviewURL+"12924037","141");    //?????????????????????
		placeAutoUrl(revList, driver,reviewURL+"18682831","142");    //??????????????????		
//??????x	placeAutoUrl(revList, driver,reviewURL+"10762824","143");    //????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"8091417","144");     //???????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"8088618","145");     //?????????
		placeAutoUrl(revList, driver,reviewURL+"16106479","146");    //???????????? ??????
		placeAutoUrl(revList, driver,reviewURL+"26602585","147");    //???????????????
																			  //????????????(148)
		placeAutoUrl(revList, driver,reviewURL+"8105816","149");	 //?????????
		placeAutoUrl(revList, driver,reviewURL+"11247110","150");    //????????????
		placeAutoUrl(revList, driver,reviewURL+"27158330","151");    //?????????????????????
		placeAutoUrl(revList, driver,reviewURL+"10842950","152");    //??????????????????
		placeAutoUrl(revList, driver,reviewURL+"125251387","153");   //???????????????
		placeAutoUrl(revList, driver,reviewURL+"9511628","154");     //???????????????????????????
		placeAutoUrl(revList, driver,reviewURL+"11755111","155");    //????????????
		placeAutoUrl(revList, driver,reviewURL+"10493578","156");    //??????????????? ??????
		placeAutoUrl(revList, driver,reviewURL+"8102174","157");     //???????????????
		placeAutoUrl(revList, driver,reviewURL+"10901906","158");    //???????????????			
//??????x	placeAutoUrl(revList, driver,reviewURL+"25035970","159");    //???????????????
		placeAutoUrl(revList, driver,reviewURL+"11620926","160");    //???????????????
		placeAutoUrl(revList, driver,reviewURL+"8133251","161");     //?????????
		placeAutoUrl(revList, driver,reviewURL+"12706186","162");    //????????? ???????????? ????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"21510540","163");    //???????????????
		placeAutoUrl(revList, driver,reviewURL+"10482115","164");    //??????????????? ?????? ????????????
		placeAutoUrl(revList, driver,reviewURL+"27025531","165");    //??????????????? ??????
		placeAutoUrl(revList, driver,reviewURL+"8149034","166");     //????????????
		placeAutoUrl(revList, driver,reviewURL+"10923704","167");    //???????????????
		placeAutoUrl(revList, driver,reviewURL+"26564223","168");    //???????????? 45??????
		placeAutoUrl(revList, driver,reviewURL+"27491575","169");    //???????????????
		placeAutoUrl(revList, driver,reviewURL+"9641200","170");     //??????????????????
		placeAutoUrl(revList, driver,reviewURL+"17101514","171");    //??????????????????
//??????x	placeAutoUrl(revList, driver,reviewURL+"761418386","172");   //?????? ??????
		placeAutoUrl(revList, driver,reviewURL+"12868448","173");    //?????? ????????????
		placeAutoUrl(revList, driver,reviewURL+"25815063","174");    //?????? ???????????? 
//??????x	placeAutoUrl(revList, driver,reviewURL+"8011765","175");     //???????????????????????????
		placeAutoUrl(revList, driver,reviewURL+"345442586","176");   //????????????????????? ?????????
		placeAutoUrl(revList, driver,reviewURL+"11203702","177");	 //?????????
		
		MakeCsv.createCSV(revList, "ReviewerList", "src/main/resources"); //csv?????? ??????
																	driver.close();}} 
		
		