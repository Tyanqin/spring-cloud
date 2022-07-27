package com.tx.runner;

/**
 * 以前的逻辑有每隔一段时间刷新一次 pub key
 */
//@Configuration
//@Slf4j
//public class AuthKeyRunner implements CommandLineRunner {
////    @Autowired
////    private RedisTemplate<String, Object> redisTemplate;
//
//    @Autowired
//    private KeyConfiguration keyConfiguration;
//
//    @Autowired
//    private RsaKeyHelper rsaKeyHelper;
//
//    private static final String REDIS_USER_PRI_KEY = "AG:AUTH:JWT:PRI";
//    private static final String REDIS_USER_PUB_KEY = "AG:AUTH:JWT:PUB";
//    private static final String REDIS_SITE_PRI_KEY = "AG:AUTH:SITE:PRI";
//    private static final String REDIS_SITE_PUB_KEY = "AG:AUTH:SITE:PUB";
//    private static final String REDIS_CENTER_PRI_KEY = "AG:AUTH:CENTER:PRI";
//    private static final String REDIS_CENTER_PUB_KEY = "AG:AUTH:CENTER:PUB";
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (redisTemplate.hasKey(REDIS_USER_PRI_KEY)&&redisTemplate.hasKey(REDIS_USER_PUB_KEY)
//                &&redisTemplate.hasKey(REDIS_SITE_PRI_KEY)&&redisTemplate.hasKey(REDIS_SITE_PUB_KEY)
//                &&redisTemplate.hasKey(REDIS_CENTER_PRI_KEY)&&redisTemplate.hasKey(REDIS_CENTER_PUB_KEY)) {
//            try {
//                keyConfiguration.setUserPubKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PUB_KEY).toString()));
//                keyConfiguration.setSitePubKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SITE_PUB_KEY).toString()));
//                keyConfiguration.setCenterPubKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_CENTER_PUB_KEY).toString()));
//            }catch (Exception e){
//                log.error("初始化公钥/密钥异常...",e);
//            }
//        }
//    }
//
//    @Scheduled(cron = "0 18 * * * ?")
//    public void refreshPubKey() {
//        if (redisTemplate.hasKey(REDIS_USER_PRI_KEY)&&redisTemplate.hasKey(REDIS_USER_PUB_KEY)
//                &&redisTemplate.hasKey(REDIS_SITE_PRI_KEY)&&redisTemplate.hasKey(REDIS_SITE_PUB_KEY)
//                &&redisTemplate.hasKey(REDIS_CENTER_PRI_KEY)&&redisTemplate.hasKey(REDIS_CENTER_PUB_KEY)) {
//            try {
//                keyConfiguration.setUserPubKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PUB_KEY).toString()));
//                keyConfiguration.setSitePubKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SITE_PUB_KEY).toString()));
//                keyConfiguration.setCenterPubKey(rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_CENTER_PUB_KEY).toString()));
//            }catch (Exception e){
//                log.error("初始化公钥/密钥异常...",e);
//            }
//        }
//    }
//}
