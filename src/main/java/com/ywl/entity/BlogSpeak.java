package com.ywl.entity;

public class BlogSpeak {
    private String id;

    private String blogId;

    private String tel;

    private String email;

    private String addtime;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId == null ? null : blogId.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public BlogSpeak(String id, String blogId, String tel, String email,
			String addtime, String content) {
		super();
		this.id = id;
		this.blogId = blogId;
		this.tel = tel;
		this.email = email;
		this.addtime = addtime;
		this.content = content;
	}
    
}