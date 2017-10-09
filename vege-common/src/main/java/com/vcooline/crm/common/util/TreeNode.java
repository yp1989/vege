package com.vcooline.crm.common.util;


public class TreeNode {

    private String id;

    private String name;

    private String type;

	/*private List<TreeNode> children;*/

    /**
     * 子节点的信息
     */
    private AdditionalParameters additionalParameters;


    public AdditionalParameters getAdditionalParameters() {
        return additionalParameters;
    }

    public void setAdditionalParameters(AdditionalParameters additionalParameters) {
        this.additionalParameters = additionalParameters;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
