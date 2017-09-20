
 /** 
 * @discription 在此输入一句话描述此文件的作用
 * @author 徐志远
 * @created 2017年6月13日 上午9:58:57
 * tags 
 * see_to_target 
 */

package org.marketing.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.google.gson.Gson;


/**
 * Title: SysUtil.java
 * Description: 系统公共属性及方法
 * @author 徐志远
 * @created 2017年6月13日 上午9:58:57
 */

public class SysUtil {
	
	//RESULT_TRUE RESULT_FALSE 返回结果
	public static final String RESULT_TRUE = "true";
	public static final String RESULT_FALSE = "false";
	
	//英文项目名
	public static final String PRO_NAME = "LoveSpace";
	//项目访问路径前缀
	public static final String REQUEST_PRO_PREFIX = "http://foney.4kb.cn";
	//头像物理保存路径
	public static final String HEAD_UPLOAD_URL = "E:/file/image/head/";//开发环境
//	public static final String HEAD_UPLOAD_URL = "E:/ProjectFormal/LoveSpace/file/image/head/";//正式环境地址
	//头像网络访问路径
	public static final String REQUEST_HEAD_URL =  "/file/image/head/";
	//消息图片物理保存路径
	public static final String MESSAGE_UPLOAD_URL = "E:/file/image/message/";//开发环境
//	public static final String MESSAGE_UPLOAD_URL = "E:/ProjectFormal/file/image/message/";//正式环境地址
	//消息图片网络访问路径
	public static final String REQUEST_MESSAGE_URL = "/file/image/message/";
	
	//用户二维码存放物理路径
	public static final String BARCODE_URL = "E:/file/image/barcode/";//开发环境
//	public static final String BARCODE_URL = "E:/ProjectFormal/file/image/barcode/";//正式环境地址
	//二维码网络访问路径
	public static final String REQUEST_BARCODE_URL = "/file/image/barcode/";
	
	//用户默认头像访问地址
	public static final String REQUEST_CUSTOMER_DEFAULT_HEAD = "/file/image/head/default_head.png";
	//用户头像物理存储地址
	public static final String  CUSTOMER_DEFAULT_HEAD= "E:/file/image/head/default_head.png";//开发环境
//	public static final String  CUSTOMER_DEFAULT_HEAD= "E:/ProjectFormal/file/image/head/default_head.png";//正式环境地址
	
	//故事图片存放物理地址
	public static final String STORY_URL = "E:/file/image/story/";
	//故事图片访问地址
	public static final String REQUEST_STORY_URL = "/file/image/story/";//开发环境
//	public static final String  REQUEST_STORY_URL= "E:/ProjectFormal/file/image/story/";//正式环境地址
	
	/**
	 * 
	 * 名称：parseJsonWithGson 描述：把json字符串转换为指定对象
	 * 创建人：xyz 创建时间：2017年7月28日上午12:07:44
	 * @param obj
	 * @param type
	 * @return
	 *
	 */
	public static <T> T parseJsonWithGson(String obj, Class<T> type) {
		Gson gson = new Gson();
        T result = gson.fromJson(obj, type);
        return result;
	}
	
	/**
	 * 
	 * 名称：parseBase64StrToImage 描述：把base64位字符串转换为图片
	 * 创建人：xyz 创建时间：2017年7月28日上午12:39:40
	 * @param imgStr
	 * @param path
	 * @return
	 * @throws IOException 
	 *
	 */
	public static boolean parseBase64StrToImage(String imgStr, String path) throws IOException {
		if(imgStr == null) {
			return false;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		//解密
		byte[] b = decoder.decodeBuffer(imgStr);
		//处理数据
		for (int i = 0; i < b.length; i++) {
			if(b[i] < 0) {
				b[i] += 256;
			}
		}
//		File file = new File(path);
//		if(!file.exists()) {
//			file.mkdirs();
//		}
		OutputStream out = new FileOutputStream(path);
		out.write(b);
		out.flush();
		out.close();
		return true;
	}
	
	/**
	 * 
	 * 名称：parseImageToBase64Str 描述：把图片转换为base64编码字符串
	 * 创建人：xyz 创建时间：2017年7月28日上午12:39:04
	 * @param path
	 * @return
	 * @throws IOException 
	 *
	 */
	public static String parseImageToBase64Str(String path) throws IOException {
		InputStream inputStream = new FileInputStream(path);
		byte[] data =  new byte[inputStream.available()];
		data = new byte[inputStream.available()];
		inputStream.read(data);
		inputStream.close();
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}
	
//	public static void main(String[] args) {
		//data:image/png;base64,
//		String imgStr ="iVBORw0KGgoAAAANSUhEUgAAAHgAAAB4CAYAAAA5ZDbSAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyNpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDE0IDc5LjE1MTQ4MSwgMjAxMy8wMy8xMy0xMjowOToxNSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChNYWNpbnRvc2gpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkRDNTU5NzJBNjQ3RTExRTQ4Qjc3QTUwMUFDQThFOUNGIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkRDNTU5NzJCNjQ3RTExRTQ4Qjc3QTUwMUFDQThFOUNGIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6REM1NTk3Mjg2NDdFMTFFNDhCNzdBNTAxQUNBOE"
//				+ "U5Q0YiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6REM1NTk3Mjk2NDdFMTFFNDhCNzdBNTAxQUNBOEU5Q0YiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz45GYa6AAAS+ElEQVR42uxdCZRUxRV90yxqQBBxIUQUjCyKuyIiIaJxISoqigoGTZSJWzDoUeOWCGgiShAVXMAFEYxLAMV9iQpuA8YBN1CDRImoERQVGDGIzKTu6dtS/bq6p3vmV///Z/qd8w707z/9q979VW+pV6/KZPQb0gBoC8O7G97J8I6GdzDc3nBbcgvDTQ1vzvvXGP7e8DeGV5I/Nfwfwx8YXmL4LcNfx10wTWPY5uaG9zXcy3Afw3sb7lDgb6SAbmN4uxz3LTO8wPBLhucarjT8XQng4Glbw/0N9zN8mAWQb+pAPoafqww/a/hxw48aXh51wZVFeIpubfgEw4MM9zXcJGLt22D4BcP3G/674VUlgPOj/QyfTXBb5Pk36w2/a3gRdeiHnF7/Sz1axXuqeH9Lw804E0BHb8OpuhN1eHfDO/OefAi6fLrhSYbnlQDOpIThYw1fYPiAPO7/zPBzhl+mQBcRwCCpGYHuSV3/C8Pt8vi7CsPXGZ5luLqxA1xmeIDhkYZ3q+XeNzhKnuT/a0Jo656Gf2l4oOG9arn/bfbroRDaGgmAoVfHGt4nxz0fGZ5s+F7D70dMlXQ2fLLh0w1vn+O++YYvNDynsQAMXTfG8OAs3+Ntf8bweMNPRWGay0O9HG54OC38siz3wRj7A22DojaumM8aZvidLOACyHsM70F36IkYgJtq95Ns8x7sg6vdg2grDCum3Iv1oI6GXzQ8weHD1tDN2NXwKdRdcaW32Yfu7FONI8AygbLo1FAAHmL4TcO9s+gnWM0n0c1pKPQe+4S+VTq+701DcUicAd7E8O2Gpxlupb5DUOAc+rzzpOHSPLpZZzsCIa"
//				+ "0om9spq1gBDEMK8dtyx3ePcQq7NSY6NggdPZF9fszxfTlltV1cAIav+KrhHur6Wo7aow1/Io2PPmHfz6EsbOpBme0ZdTcJ7sIMSYYCbVps+HjDC4sgyCYMQiD6hHBjF0mGH7eUjaFPhBa/lGRYczH1P0bR65KMMfsmGJQz2TabqhhEeTqKAA+gr9dcXX+EluVqjwJrxpdrCP/doo6/8zV98GkU8nqPbU7p4KPV9e/oRj4YpSkaEZ3pDnDHEXhf4ALIPxr+WJLLdyfVA9zU753I3/qYv72Fp7avpmyuU9eb08U6OSoAH2d4qqQv51XTob/AkyG1CYWPDIyrJLkaFDRtw9/GMy73ZOlCNhdSVtVKzUylWgt1ikbgfZYaudBhp3H68UGH0ALfKcc9KwzPppsCnxTLh59T9wp18dYMNnQzvL/hg2p5UZbQ3XnWU7+gxu5SAwXTNVbZngwDYKz+vCLpkakNnCZnehAAsk/+LMl4riveu5Jv/b0MoNQULIvkwgemxlMluU6sCb85hrPH9x76iBH7gAK5igGTt4sJMHy2ucp3wxTzG08jdysaHX0c32FRH6tSk6wRWl/6kSRXiS6VZPKeppepP7/wNJKnKPUJe6AX//Wug5tT2NoxH+YJXGRIVjjAxQj6K12NcQGCm/LZbzLclc/Q1vTP2KYdPPR3GmWpB9SDdbED6gLwLY4gxjXUi0ETOjZHkmuvNmFteD9O11UeXZkqPgPPekd915l63kcE6lbKVAdDbvYNMPzMoerao9RJQROS7rBk2FFdf1iSabOvFzEKBT3WkwalTZ3YxtYennkZZWvTUClwgaIQgDs63qDF1BlBR38SNDZ0Gs9tNERWS/EpFWW6zWFszpDgsz5rKNvF6vrNUsBSY6KA++6R9FWhtRS2j3TRSxiR0tPWmVKcUGI22sA23Opw3a7w8LxVjDOsdUTAEkECjAC5Xs+Fg+4jtgxX5Up1DeHOcyU6dC7bZNPlVB1B0yLK2qbexCQQN6kDH2L7u8js7y/BZw"
//				+ "smGJywjbh3aeRUSbQICyr/lOSCRopeY9Ak6OhdGfXxkdY17K/CEuSy+o7g6xS4qzhN+UgFHarAhXsyOILgpnTyYOVCoe3lHp5VQ5nb6nBzyYxjFwxwHxoWWj/6WM9tSsvRphskme4TVULbrlfXLhU/e74g84vVtROyBH/yAriMjbfDgpUOKzIoGqJcok8dujiKdBXbansbp3h61m2SmeOlMcob4AGSnpSOaWK4+EuzGa4+Xx3Rqdk1Vf/FYZT6oBQGNcooHVAowLg+Ul2Dr1fhqeHIJ7bTVRDjnSzxobskPS4Na3oXT8+qIBY2jcqGZTaA+6sgA/y/ER4FdKL6DJ/72xgB/C3bbNNgj88boeIBuxKzvAG+SH2+X/zmLR/hADhu9Df1+VCPz3qXmOTCLKsfDD9urpr3d6Mv7IPacHpLvWxYrG8nIe7Iq4eviuW89tash0Q/X2FVqICFysDqJSrP3DWCz1Cfn/EIbkpf2e14PobgpgbCbOszYtM9PT7vHWKTC7sMgFs79OF4z4LZVX1+VeJLlbX0LWi60WHLtM4FMNJt7LIJSDh7ynMjf6o+vxdjgP9VS9+CpqeJUYpaEMOcANs0RfxvL9lafV4SY4D1JvWtPD+v2uFOZgUYhs2BtViGPkhvJ10eY4CX19I3H3Sf+nygWLVEEsr3tRetF0hxyiZoIayJMcC67a2KNGssUMbdUS6AtS86s0hC+U4aDjUPqW86snWkBhh7ew5WNz1VpMZVhTCtNbTZSGN1MDH9AeB91XSC1ZFiJbXpgp/bxhjgNupzsarfvSHpK1rAsocNsE7HeaGIwQadzL1TjAHuXEvffBGwmqOuHWADrKvLvVJEoWi/t1uMAe4aok9fkQvgfUIEWKuCnjEGeJ9a+uaTXnG1JUG9YVdqQ47RoiI2DM9aYX3GLr+yGIJbpgzVz0OQo50fBkzbAGCdXP6O+N3Z7tIfs5WRtXcMAUab7Y1qs6W4iybrHSpht4TDMFgYgnAeV5+HxBBgvSP/4RDaoLeYdg"
//				+ "PAHdXFD0NoGITxjQJ4sxiBi7aeqvzfWSG04wP1eUcAvKO6uDSEhmFR3M5QQJD+tBgBfJqkLyygxsbaENqhsds+4QgsfBSSkLAP1165wlaQljEAtyXbmqJq9iUM0thtA4C3VBe/DKlxWEu1Y6owWK6IAcB/UsbVDMlcFy4WaezaAmBdeOSLEIU1Qlnw50ntldXDJLTtfGXJjgixPV+4RrCeBsM8DApm/jjrMwLm2CfcKoLgbk67wT64Y5yEm5GisWuRkMysjrALhI5SAQK4cdgPG6VjddAWpPZ2UfGDUSG3S++dbpKQ6C24I4n8BOU2odzfhAgBPEHSSxDCYh4o4Sfr66XXlgmJJiGx+7eSHglCEbJJIY/kJmzD2dY1tLFcIlrQPOEYsVFZcEeu0SXq2hm0UsPQybBVpktm7vHFkpkXFabLljaiEw6dG6VRjapyV6lrKO1XWWTrGpvjkK+td/FdFaLPm22GSdPJCcksILaFRIvgC1+kpmsYXtiigW2bPkOa+G2UT0Sphl3UtHxRBP10Xc7pGwC8QjvHEVQlYzl6vrKuIcENFQHepy/aIsDnoZTh7yRZwuhySU+m+4ptGRtBOekc8xUAeGUMAAZhQQJ7iHXmwk/ofy7lv1jorst6cqoYKX4DuwVQylBXsatgGx6OqIx0VHIlaknoZO3tJbqEWGsfWthXqw5txZF8Pvs0m3oT1m2ucsKokoMsEiQaZEv4+5Kzxe0S7YNENHbLm0rm8mBHiTZV01WZSTCHOaxqADWIXB9azZGMOhhfSPRJY7c04QC4Uww6sqkk00ITHKE+qt/hN9/jM3rwmVEnjd2HTSVze0r3iDZ+Exo3GJWH0hDy7XLsR4Y/jmjVPyQZf8aRsesiKCOdfrUYO/y3VIbWeuqo9RFpNF44FEj7tcOISHPqDb9FXkKjawMDN1vShWhm9XGVxWV8+5GTvTs511o0dPLdhu+U4ibW5aJmtDHsxY+2qRIOMF46WF8giBDmydEQODbDoVZz7yz3YETh/AScBD"
//				+ "5HkrlkQRlAmJaxebuvJE/+PiTHjAHL+lpJlhoMszIBrPvXlUG6QypqpXem9w6xoTimdT5dEd2OdTSujqMVfIwkKxC8FbB1W83fHM9nbM1nznRMzQewrfPZ9rBIy2p+6k0VyZIVX2TCjoYnyToMiS0gl9LnHUgdWMycp7V85kC2ATpZFwHdy2p/GLszDnDMLD8ArLPi+0rxks8RJUIWxJuOEbCUPi8SA69xBGXCoJWcktGmcslMdOvHvoyQzO2kPlVa31wAV0p6uZ/2UpxgPuK7iPOOVMJAZgJqJGOvzx0RMvhs+p5GVle29Wv10qJPr4m/inda/9p5YWv47B8AhgCfV390uOdGlbMRe6jrsyg0lMqNw+bw79jWrpKZC707B0+55zbome+51KCwlwafUDcN9Dgl4zzd25VluobuEHzdFRI/WsG2D5X0NfbN2NeJHqdsjdXjG+fujZXu2tGYsdcUu0iwdTpa8S0/yKEvUIL3A2kYBP08zWH4ID5+rARb/W4nhRF8fyySfKZHMC68oP44yIKaeIFecoB7B681FHCFfTmII9emgyiDdgE+S2P0QgpcDTDoAfX5dAkmw+PHfHt3t64hKHAxreSGVIjF1s1nsI81Si/PpkyCCMgMzYWhC2Dbv9whAGNra3aom5pGYHiMkYZPY9jXDcrnny2ZC/SF0uGSfrze2toAXuUYxcPr0QDEgR+V9NIGqSzEydJ4aDL7bI/krpRNfZIchzsG6KpcAIP0mQyH1dGXg7GGXXa6JANSYaZI46Mp7LtNPSmjuqQC70JscmHnBBjJbHNVlOSyOjTgWod/5usQy7iQ69DJfpRVoXSppEcb54qqFS05DCj9wEFSWHwVBTEvUNcequOL0tAIMnhQXbtAMgvB5qJuDuv52mxWmIugGxaq6TbffTfwASepa9hOeZrEs9B30FRD70RvUoPM8i0/PEpN6wsl86TSnABjuUxvg8R+oV556F1syrLzc9dxBlhVwjbNmB0k6UuPrSm72vRxL2Jh0wjJsl"
//				+ "yay8fFlDpf6eLxknuV6XzHS4Ap6Y0Sphn0pkNl7e9QbaIwuFFhsIBYSaEA10j65mbQvgxMZJua9TaTBZJZdr5EG+kGZdCmpt9sUzVk38MxqGrqAjAIYbXpDse9veNejO5N1TR/joR73m/UqZqg2cuhm2YZFO0lMzAEbF7M9YB8wpCYMtYoXTFRTRNHSvrRpyDEmF8tYVgrIWlPn6wOWR6hpuZJyrapqmU6zxvgZQ5dgYS4s6zf0L7dypJLVBCNksxslWstfCDroxy2zbIgAAbdIplpPWMZTfmVZB4fc71EI70mLoRskHHqGmQ6hDLWG90qHKM+i1U2Om8DtxOtYXubyGJOH51VYztJuMVc4kiYfpdK+vbd96mn7Vg+1pKRTpXX8mohS4HY4jJMXesimbUubyqBW2ffWNch6SyZNaiHSQFr54Wu9SJL4c4c31fR9C9R3ehGyX1m8mRiIL4ABmFFpDLLd/eWdG+9CLKbmuW7SqnDwdN1ARjhtQHiziv6rIRRvekTx7XVlPm6YgAM+pimu45/otzB8SWM6kyQ3ZWOYMhZUscDPuqTb3UfG2OHyRAoR1bBKSWsCqZTKDt7saGGMq5zmab6JtSNksywGho4RTKzF0qU266ZIpkrSeOlnuURg8iYRLAbmf0b1O/eRAc9UcIvp/zHUla2nDZQpucF8YAgCHtzcDixTn9FrPQhiWa12LAJMpkpmfFkyPAkylSiAjAIaSjHOPw4FO3EHqRdS5j+QKlNd8c64gjHSIAHgwY9feKQxJ9L+jl6IES8sLKEIp5ljRzcM/nC6wjVp5RdoIeC+tCPKCPQ0xEMwUYzLFo8IslN1I2N2rPvEyWzHEQlZRb4SWm+DCD4bChYdofjOyx7LaJv1xgMsDKOWhQM7+/4/k7KystBlj4F/D9JZivAv9NRL6ycIEcYy177N2Bw92cfJ0pmoVDIBJWDyikriRvAKUKmIJa3XAde9qQA4OB3a0DAdmOfsr3AFZTJ1GL4YcWgD2hA/F4yC5CX0cVCbu"
//				+ "/dMbe2u7MPC9knbVCuoQz6SJG2yxZTByKmOoFCmOH4HlEcHA/3Fi3JfjHR0Qm2FW1+m31w5TbPZN8nSBELmhaS0RE09WW0JtdJox/RCEEs9v2IAYvF+EHUobkq9C5gMGNOOBbe6FBz0jGFYRlsVB5T8wKOfIwUNLomhLbuydE6UGo/AhfT9EhJBoBqwhPw6EhsOkgwqoM3PZ8ibFh3RhnDlxhA8XHmMWo+7kwjCToT5QzzKb1QwZlplkSgtnRUANauxZk0UvKtKIv47bv0r/8tyeS1ZXwRkB9WxXvsguCoeIPN16hwvw2DLx0luaugO8HNtyoOdtZjny9yl+dFywkfHdltQ60J8mBa4E0i1j6s+LxI+wDgRnJzXZQBtmlbRoGg/w6T8M52qqJqQB0qbNdcHnXBxQVgmzBtYhNcL+pGGDsdPD1rGY076HpsEquUmFUEiiPALmojyfJEnalHwe2pX9tSlzeXjUfvQGeu478ryZ9Sdy+lSwZ//Ku4C+b/AgwAO+Qanyc2+SEAAAAASUVORK5CYII=";
//		String path = "D:\\test.jpg";
//		SysUtil.parseBase64StrToImage(imgStr, path);
//		System.out.println(SysUtil.parseImageToBase64Str(path));
//		System.out.println();
//	}
	
	private static final char[] str = {'0','1','2','3','4','5','6','7','8','9','a','b', 
		'c','d','e','f','g','h','i','j','k','l','m','n', 
		'o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static String getValidateCode() {
		String validate = "";
		while(true) {
	        char c = str[new Random().nextInt(36)];
	        if(!validate.contains(c+"")) {
	            validate += c;
	        }
	        if(validate.length() == 6) {
	            break;
	        }
	    }
		return validate;
	}
	
	public static void main(String[] args) {
		System.out.println(SysUtil.generateNumCode(4));
	}
	
	  /**
     * 随机生成指定长度的验证码
     *
     * @param length 验证码长度
     * @return 生成的验证码
     */
    private static String generateNumCode(int length) {
        String val = "";
        String charStr = "char";
        String numStr = "num";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? charStr : numStr;
            //输出字母还是数字
            if (charStr.equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if (numStr.equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
	
}
