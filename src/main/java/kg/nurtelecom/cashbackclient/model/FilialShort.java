package kg.nurtelecom.cashbackclient.model;

public class FilialShort {
        private Long id;
        private String name;
        private String address;
        private Float averageRate;

        public FilialShort() {
        }

        public FilialShort(Long id, String name, String address, Float averageRate) {
                this.id = id;
                this.name = name;
                this.address = address;
                this.averageRate = averageRate;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public Float getAverageRate() {
                return averageRate;
        }

        public void setAverageRate(Float averageRate) {
                this.averageRate = averageRate;
        }

}
