package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fileupload")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public Map fileSave(MultipartFile file){
System.out.println("正在上传图片到文件服务器。。。");
        int type = fileService.getFileType(file);
        if(type==1){
            String str = fileService.saveFile(file,"jpg");
            System.out.println(str);
            Map<String,Object> map2=new HashMap<>();
                Map<String,Object> map=new HashMap<>();
                map.put("code",0);
                map.put("msg","");
                map.put("data",map2);
                map2.put("src",str);
                return map;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",1);
        map.put("msg","");
        return map;

//        String prefix="";
//        String dateStr="";
//        //保存上传
//        OutputStream out = null;
//        InputStream fileInput=null;
//        try{
//            if(file!=null){
//                String originalName = file.getOriginalFilename();
//                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
//                Date date = new Date();
//                String uuid = UUID.randomUUID()+"";
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                dateStr = simpleDateFormat.format(date);
//                String filepath = "D:\\mycode\\LayUiTest\\src\\main\\resources\\static\\images\\" + dateStr+"\\"+uuid+"." + prefix;

//
//                File files=new File(filepath);
//                //打印查看上传路径
//                System.out.println(filepath);
//                if(!files.getParentFile().exists()){
//                    files.getParentFile().mkdirs();
//                }
//                file.transferTo(files);
//                Map<String,Object> map2=new HashMap<>();
//                Map<String,Object> map=new HashMap<>();
//                map.put("code",0);
//                map.put("msg","");
//                map.put("data",map2);
//                map2.put("src","/images/"+ dateStr+"/"+uuid+"." + prefix);
//                return map;
//            }
//
//        }catch (Exception e){
//        }finally{
//            try {
//                if(out!=null){
//                    out.close();
//                }
//                if(fileInput!=null){
//                    fileInput.close();
//                }
//            } catch (IOException e) {
//            }
//        }
//        Map<String,Object> map=new HashMap<>();
//        map.put("code",1);
//        map.put("msg","");
//        return map;

    }
}