package com.personInfo.constants;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public class IndexLibaryConstants {

    public static  final String REQUIREMENTS_MAPPING_TEMPLATE = "\"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"person_id\":{\n" +
            "        \"type\":\"keyword\"\n" +
            "        , \"index\": false\n" +
            "      },\n" +
            "      \"age_range\":{\n" +
            "        \"type\":\"text\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"height_range\":{\n" +
            "        \"type\":\"keyword\",\n" +
            "        \"index\":false\n" +
            "      },\n" +
            "      \"marry_status\":{\n" +
            "        \"type\":\"keyword\"\n" +
            "        , \"index\": false\n" +
            "      },\n" +
            "      \"education_background\":{\n" +
            "        \"type\":\"keyword\"\n" +
            "        , \"index\": false\n" +
            "      },\n" +
            "      \"income\":{\n" +
            "        \"type\":\"keyword\"\n" +
            "        , \"index\": false\n" +
            "      },\n" +
            "      \"housing_status\":{\n" +
            "        \"type\":\"keyword\"\n" +
            "        , \"index\": false\n" +
            "      },\n" +
            "      \"car_status\":{\n" +
            "        \"type\":\"keyword\"\n" +
            "        , \"index\": false\n" +
            "      },\n" +
            "      \"other_requirements\":{\n" +
            "        \"type\":\"keyword\"\n" +
            "        , \"index\": false\n" +
            "      }\n" +
            "    }\n" +
            "  }";

    public static  final String BASCI_INFO_MAPPING_TEMPLATE = " \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"person_id\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"person_name\":{\n" +
            "        \"type\": \"keyword\", \n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      },\n" +
            "      \"is_vip\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"sorts\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"sex\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"age\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"image_path\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"disable_number\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"analyzer\": \"standard\"\n" +
            "      },\n" +
            "      \"work_addr\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"index\": false\n" +
            "      },     \n" +
            "      \"household_addr\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"index\": false\n" +
            "      },  \n" +
            "      \"marital_status\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"height\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },         \n" +
            "      \"weight\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },      \n" +
            "      \"degree\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      },      \n" +
            "      \"income\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },      \n" +
            "      \"occupation\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      },            \n" +
            "      \"housing_status\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      },        \n" +
            "      \"car_status\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      },        \n" +
            "      \"expected_marry_time\":{\n" +
            "        \"type\": \"date\",\n" +
            "        \"index\": false\n" +
            "      },        \n" +
            "      \"person_intro\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      },        \n" +
            "      \"person_sign\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      },        \n" +
            "      \"location\":{\n" +
            "        \"type\": \"geo_point\"\n" +
            "      },        \n" +
            "      \"wechat\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": false\n" +
            "      },        \n" +
            "      \"wechat_code_images_path\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"index\": false\n" +
            "      },          \n" +
            "      \"qq\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"index\": false\n" +
            "      },          \n" +
            "      \"email\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"index\": false\n" +
            "      }\n" +
            "    }\n" +
            "  }";

    public static final String DETAIL_MAPPING_TEMPLATE = "\"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"person_id\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"disable_type\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"disable_level\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"is_provide\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"auxiliary_tool\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"cause\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"is_genetic\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"brother_number\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"living_will\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },     \n" +
            "      \"is_smoking\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },  \n" +
            "      \"marry_form\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"is_drinking\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },         \n" +
            "      \"fertility_status\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },      \n" +
            "      \"keeping_status\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },      \n" +
            "      \"hobby\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },      \n" +
            "      \"blood_type\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },            \n" +
            "      \"company_type\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },        \n" +
            "      \"work_industry\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },        \n" +
            "      \"housing_location\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },        \n" +
            "      \"person_tag\":{\n" +
            "        \"type\": \"text\"\n" +
            "      }  \n" +
            "    }\n" +
            "  }";

    public static final String USER_MAPPING_TEMPLATE = "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"user_id\":{\n" +
            "        \"type\":\"integer\"\n" +
            "      },\n" +
            "      \"nick_name\":{\n" +
            "        \"type\":\"keyword\"\n" +
            "      },\n" +
            "      \"login_name\":{\n" +
            "        \"type\":\"keyword\"\n" +
            "      },\n" +
            "      \"password_md5\":{\n" +
            "        \"type\":\"keyword\"\n" +
            "      },\n" +
            "      \"is_deleted\":{\n" +
            "        \"type\":\"integer\"\n" +
            "      },\n" +
            "      \"locked_flag\":{\n" +
            "        \"type\":\"integer\"\n" +
            "      },\n" +
            "      \"create_time\":{\n" +
            "        \"type\":\"date\"\n" +
            "      }\n" +
            "    }\n" +
            "  }";

    public static final String FANS_MAPPING_TEMPLATE = "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\":{\n" +
            "        \"type\":\"integer\"\n" +
            "      },\n" +
            "      \"user_id\":{\n" +
            "        \"type\":\"integer\"\n" +
            "      },\n" +
            "      \"follower\":{\n" +
            "        \"type\":\"integer\"\n" +
            "      },\n" +
            "      \"status\":{\n" +
            "        \"type\":\"integer\"\n" +
            "      },\n" +
            "      \"create_time\":{\n" +
            "        \"type\":\"date\"\n" +
            "      },\n" +
            "      \"update_time\":{\n" +
            "        \"type\":\"date\"\n" +
            "      }\n" +
            "    }\n" +
            "  }";

    public static final String FOLLOW_MAPPING_TEMPLATE = "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\":{\n" +
            "        \"type\":\"integer\"\n" +
            "      },\n" +
            "      \"user_id\":{\n" +
            "        \"type\":\"integer\"\n" +
            "      },\n" +
            "      \"followed_user_id\":{\n" +
            "        \"type\":\"integer\"\n" +
            "      },\n" +
            "      \"status\":{\n" +
            "        \"type\":\"integer\"\n" +
            "      },\n" +
            "      \"create_time\":{\n" +
            "        \"type\":\"date\"\n" +
            "      },\n" +
            "      \"update_time\":{\n" +
            "        \"type\":\"date\"\n" +
            "      }\n" +
            "    }\n" +
            "  }";
}
