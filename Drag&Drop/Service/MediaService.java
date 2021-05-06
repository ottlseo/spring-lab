package com.example.spring02.util;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
 
public class UploadFileUtils {
    //로깅을 위한 변수
    private static final Logger logger 
        = LoggerFactory.getLogger(UploadFileUtils.class);
 
    //파일 업로드메서드, 업로드경로를 매개값으로 받음. 
    //어디서 호출??>> AjaxUploadController의 uploadAjax메서드에서 호출
    public static String uploadFile(String uploadPath
            , String originalName, byte[] fileData) 
                    throws Exception {
        // uuid 발급하여 저장할 이름(uuid + 원래 이름) 설정
        UUID uid = UUID.randomUUID();
        String savedName = uid.toString() + "_" + originalName;
        
        // 업로드할 디렉토리 생성
        //calcPath는 날짜별로 디렉토리 만들어 경로 설정하는 메서드(하단에 작성)
        String savedPath = calcPath(uploadPath);
        File target = new File(uploadPath 
                + savedPath, savedName);
        
        // 임시 디렉토리에 업로드된 파일을 지정된 디렉토리로 복사
        //FileCopyUtils는 스프링이 제공하는 클래스
        FileCopyUtils.copy(fileData, target);
        // 파일의 확장자 검사
        // a.jpg / aaa.bbb.ccc.jpg
        //파일명에 dot이 있는 경우엔 마지막 dot 뒤가 확장자
        //.substring()은 문자열에서 특정 부분만 골라낼 때 사용하는 메서드
        //substring(start, end(없으면 문자열끝까지))
        //lastIndexOf(".")는 해당 문자의 마지막 위치의 인덱스값 반환
        //마지막 dot인덱스 +1 자리부터 끝까지가 formatname(파일 확장자)
        String formatName = originalName.substring(
                originalName.lastIndexOf(".") + 1);
        
        String uploadedFileName = null;
        // 이미지 파일은 썸네일 사용
        // 확장자가 getMediaType()으로 거른 이미지파일 확장자라면,
        //(이미지파일 확장자가 아니라면 null이 리턴됨)//static 메서드
        if (MediaUtils.getMediaType(formatName) != null) {
            // 썸네일 생성
            //하단에 작성한 makeThumnail메서드(썸네일 이름 리턴)
            uploadedFileName = makeThumbnail(uploadPath
                    , savedPath, savedName);
        } else {
            uploadedFileName = makeIcon(uploadPath, savedPath
                    , savedName);
        }
        //썸네일 이름 or 아이콘 이름(경로+파일이름) 리턴
        return uploadedFileName;
    }
    
//아이콘 생성
    private static String makeIcon(String uploadPath
            , String path, String fileName) throws Exception {
        // 아이콘의 이름
        String iconName = uploadPath + path + File.separator 
                + fileName;
        // 아이콘 이름을 리턴
        // File.separatorChar : 디렉토리 구분자
        // 윈도우 \ , 유닉스(리눅스) /
        //???뭘 리턴하지?아이콘 이름에서 디렉토리 구분자 변경한거?
        //아이콘 이름이라고 쓰긴했지만 그냥 경로 + 파일명 리턴하는거
        return iconName.substring(uploadPath.length())
                .replace(File.separatorChar, '/');
    }
 
    //썸네일(이미지 리사이즈) 만들기 위해서는
    //imgscalr(이미지스칼라)라이브러리 필요 (pom.xml에 등록)
    private static String makeThumbnail(String uploadPath
            , String path, String fileName) throws Exception {
        
        // 이미지를 읽기 위한 버퍼
        BufferedImage sourceImg = ImageIO.read(
                new File(uploadPath + path, fileName));
        
        // 100픽셀 단위의 썸네일 생성
        BufferedImage destImg = Scalr.resize(
                sourceImg, Scalr.Method.AUTOMATIC
                , Scalr.Mode.FIT_TO_HEIGHT, 100);
        
        // 썸네일의 이름, 's_'가 들어간 파일은 썸네일 파일, 원본파일과 구분하기위함
        String thumbnailName = uploadPath + path 
                + File.separator + "s_" + fileName;
        
        //썸네일 이름(경로 + 파일이름)으로 파일 생성
        File newFile = new File(thumbnailName);
        
        //확장자
        String formatName = fileName.substring(
                fileName.lastIndexOf(".") + 1);
        
        // 이미지, 확장자, 새로 생성한 파일로 썸네일 파일 생성
        ImageIO.write(
                destImg, formatName.toUpperCase(), newFile);
        
        // 썸네일의 이름을 리턴함
        return thumbnailName.substring(
uploadPath.length()).replace(File.separatorChar, '/');
    }
    
 
    private static String calcPath(String uploadPath) {
        Calendar cal = Calendar.getInstance();
        String yearPath = File.separator 
                + cal.get(Calendar.YEAR);
        
        //DecimalFormat 객체는 10진수의 포맷 변경시 사용
        //한자리수 월, 날짜일 경우 01 02 03...으로 표현하기 위함 
        //format은 포맷에 맞는 문자열을 리턴
        //★★★ Calendar객체에서 1월은 0으로 출력하기때문에
        //현재 월을 알고 싶다면 Calendar.MONTH + 1 을 해줘야한다.
        String monthPath = yearPath + File.separator 
                + new DecimalFormat("00").format(
                        cal.get(Calendar.MONTH) + 1);
        String datePath = monthPath + File.separator 
                + new DecimalFormat("00").format(cal.get(
                        Calendar.DATE));
        
 
        //makeDir은 하단에 작성한 디렉토리 생성 메서드
        //File클래스의  mkdir();아니고 
        //mkdir()메서드를 활용하여 직접 작성한 메서드
        //날짜별로 디렉토리 생성
        makeDir(uploadPath, yearPath, monthPath, datePath);
        
        logger.info(datePath);
        return datePath; //날짜 디렉토리 리턴
    }
 
    // *중요- String...은 가변사이즈 매개변수 (가변인자) 배열!
    private static void makeDir(String uploadPath
            , String... paths) {
        
        //디렉토리가 존재하면 새로 만들지 않고skip//인덱스는 0부터 시작하기때문에 -1
        if (new File(paths[paths.length - 1]).exists()) {
            return;
        }
        
        //가변인자로 받은 paths에서 path를 가져와 
        //해당 디렉토리가 존재하지 않는다면 디렉토리 생성
        for (String path : paths) {
            File dirPath = new File(uploadPath + path);
            if (!dirPath.exists()) {
                dirPath.mkdir(); // 디렉토리 생성
            }
        }
    }
}
