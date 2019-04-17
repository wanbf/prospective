package com.angel.prospective.util.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author wanbf
 * @date 2019/2/26 15:04
 */
public class HttpDemo {
    public static void main(String[] args) {
        new HttpDemo().uploadDemo();
    }
    public void uploadDemo() {

        File file = new File("D:\\2.jpg");
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {

            HttpPost httpPost = new HttpPost("http://pic.lvmama.com/upaction");
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000).setConnectionRequestTimeout(1000)
                    .setSocketTimeout(5000).build();
            httpPost.setConfig(requestConfig);

            MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, null, Charset.forName("UTF-8"));
            multipartEntity.addPart("ufile", new FileBody(file, "application/octet-stream", "UTF-8"));
            try {
                String simpleDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                String fileName = simpleDate+"/test-images-"+ UUID.randomUUID()+file.getName();
                fileName = "/uploads/pc/place2/"+fileName;
                multipartEntity.addPart("fileName", new StringBody(fileName,
                        Charset.forName("UTF-8")));
                System.out.println("----------"+fileName);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            httpPost.setEntity(multipartEntity);

            CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
            try{
                InputStream is = httpResponse.getEntity().getContent();
                OutputStream os = new ByteArrayOutputStream();
                byte[] by = new byte[1024];
                while(is.read(by)!=-1){
                    os.write(by);
                }
                System.out.println(os.toString());
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status != 200) {
                    throw new Exception("上传失败，HttpStatus：" + status);
                }

            } finally {
                httpResponse.close();
            }

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getStackTrace());
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println(e.getStackTrace());
            }
        }

        System.out.println("文件上传成功！！");
    }
}
