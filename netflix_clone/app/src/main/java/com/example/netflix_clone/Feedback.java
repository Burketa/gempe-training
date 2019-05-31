package com.example.netflix_clone;

public class Feedback {


    private String feedback;
    private String string_case;
    private boolean toast_checked;

    public Feedback() {
        this.feedback = "Null";
        this.string_case = "Null";
        this.toast_checked = false;
    }

    public Feedback(String feedback, String string_case, boolean toast_checked) {
        this.feedback = feedback;
        this.string_case = string_case;
        this.toast_checked = toast_checked;
    }

    public String getString_case() {
        return string_case;
    }

    public void setString_case(String string_case) {
        this.string_case = string_case;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;

    }

    public boolean isToast_checked() {
        return toast_checked;
    }

    public void setToast_checked(boolean toast_checked) {
        this.toast_checked = toast_checked;
    }

    public String toLower()
    {
        return feedback.toLowerCase();
    }

    public String toUpper()
    {
         return feedback.toUpperCase();
    }

    public void reset()
    {
        feedback = "";
        string_case = "";
        toast_checked = false;
    }
}
