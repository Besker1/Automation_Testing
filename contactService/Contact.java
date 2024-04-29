//Besker Telisma
//CS320

package contactService;



public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        setContactId(contactId);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setContactId(String contactId) {
        validateStringLength(contactId, 10);
        this.contactId = contactId;
    }

    public void setFirstName(String firstName) {
        validateStringLength(firstName, 10);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateStringLength(lastName, 10);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateStringLength(address, 30);
        this.address = address;
    }

    private void validateStringLength(String value, int maxLength) {
        if (value == null || value.isEmpty() || value.length() > maxLength) {
            throw new IllegalArgumentException("Invalid value: length must be between 1 and " + maxLength + " characters.");
        }
    }
}
