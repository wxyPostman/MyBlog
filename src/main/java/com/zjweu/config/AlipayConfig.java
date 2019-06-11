package com.zjweu.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016093000629563";

	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCBuI8VHmvOgYskiLjfKKnTxGfjyoEumAvoaN3G00JQfAQ5ltvG00wz+cnAWwnYG121SR2jyTyof6fSWquoRE84Fs19eFLAEMCm5S+Z45YhLW7PuWcZ0Xw+VxHoPQQju8ToRjsO8op8olNyT4AlbAM7ewZ7+cXniSqq+lyE3FGe+T6qDaRHbe2nA2ca6x58NV8vr2k5CtCgmdLk0f9tOK+xVZGrOeRGO1SpZxd34hWOAdK+Ut3DF+r2DuJj5XWKl0iYMZeANKvrafjMMyJodsM6/UUjQQBjuYqM1W+dfi3EBcWg72ZZk6wHnRIHfbKlPhFoEkyTxC3pPfUzs5gP/vuxAgMBAAECggEAV0MFzVkXgGUYas0mP8gk5fW7RTrWR7e0WvUgKz214FpspSjcUxWUr2oa07DqIFvYX7j9nU4j5d1p0VF5I8o/2CVOulaUo+shDaQir0yvk0Xywv2fY3jOMUl1HFrfTAJl5TJJTDbP/iNcKwtb0tCkJAEQTZmqDaTx9O5SCnYC2gMpQj3Je1HMkc8wGhCpfZnLeQGCeGfcm3/3/2gqPsJmG6puaTz1Qjeo5PGLazocrtTtxfRTjJ3ED1L0mIwAqrOLDkVRGbJ6qOaK5WU2M+uZU1HIOU6jBaQK02hlfbsQWrKFgGuIBnjQ7cmiFUMvpaNHHAecrDZ+YlSIsQeWWU8xmQKBgQDkNir0bbL06HoNRBbuPNP2d6UJ/WefgdgbpReTdUDZ2iTnxmNxxa/VPej+mZO/i7Qjwl/kBMJPvhXNh6ZrEiNk/BcUPghrC1OeLU1sLKpPbke/YOkMGym4cmxOGmGqJbP8s68u+m/TdRCofj8jEanZDGyr8k8UC5S7q2VAN+SIJwKBgQCRhDtBG5h6ztfw7PjAOHxzd/BiN9l339GkHP2kxv1S05M6dnQWmKw67jyVFWpiLLUKqEWn91mQCjuDGaHyitMEney8PahX5bCSsRteiznDuDRbpEVS8d8I6Ucb+MEsE3YfdGeYfC5QOXrjUsrKYh9k2p1vjWfMx/wPHzNkNR6sZwKBgQCaf1F1SQ7uXrTCZmZfwy58nWNN8BBHHFCB5rKfUbIlyllR0C1iyMLRSqiCNNahxqKd0um4JMCn27hG/J7dvdnYdBHr0lNApNpnK6ROp65lN/O6zJD5cSo9hLlt5s5Xsk63ta3T0BgEwCwW5eE4jKzAFHk9rz16BJ0csFxLrYs54QKBgCkAWznTLrmbwpiuDMEMqXRXnTHvjqUKOaXGTWm6b/KAjwFwEvGy/wRz0DopmJolArYIB+h195RwbahY9prCpwasAOJhdSefHouWv6F6FUKiio4v0SC36iI2qMSm6LcknKnsQKxkgSA1sfyPfXhdAX+HYcjmzRKUXt9b6T0ZApWNAoGAE94AgCK4aKlEvQL3r/uXL9joDs8s1lPGzncMZXvPuofOtZczeZ3R+VrRnWu3iCM5Ty0/XeIs5T1KxoY3dqe4xFu3OLjS08fiEfZxzyoeT8/zCijeSSMiOEKkB7wIoly8kVkAouDsN9aT+BpcnAjGrctipN3F/u4v0wfdTEocpnE=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8088/alipaydemo/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String return_url = "http://106.14.200.154/alipaydemo/return_url.jsp";
	public static String return_url = "http://localhost:8081/";

	// 签名方式
	public static String sign_type = "RSA";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

