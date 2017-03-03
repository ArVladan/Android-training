    package promo.kit.todojurnal.model;

    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    public class ModelData {

        @SerializedName("userId")
        @Expose
        private int userId;
        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("completed")
        @Expose
        private boolean completed;

        public ModelData(int userId, int id, String title, boolean completed) {
            this.userId = userId;
            this.id = id;
            this.title = title;
            this.completed = completed;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {

            return title.toString();
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }



        @Override
        public String toString() {
            return "Id: " + this.id + "\nUser id: " + this.userId
                    + "\nTitle: " + this.title + "\nCompleted: " + this.completed;
        }

    }