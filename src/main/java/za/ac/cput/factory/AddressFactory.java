// AddressFactory.java
package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.AddressHelper;

public class AddressFactory {

    public static Address createAddress(String streetNumber, String unitNumber, String complexNumber, String complexName, String apartmentNumber, String streetName, String city, String state, String postalCode, Customer customerId) {
        if (!AddressHelper.isValidStreetNumber(streetNumber)) {
            throw new IllegalArgumentException("Invalid street number");
        }
        if (!AddressHelper.isValidPostalCode(postalCode)) {
            throw new IllegalArgumentException("Invalid postal code");
        }
        if (AddressHelper.isValidStandaloneAddress(streetNumber, streetName, city, state, postalCode) ||
                AddressHelper.isValidApartmentAddress(apartmentNumber, complexName, streetName, city, state, postalCode) ||
                AddressHelper.isValidUnitAddress(unitNumber, complexName, streetName, city, state, postalCode)) {
            return Address.builder()
                    .streetNumber(streetNumber)
                    .unitNumber(unitNumber)
                    .complexNumber(complexNumber)
                    .complexName(complexName)
                    .apartmentNumber(apartmentNumber)
                    .streetName(streetName)
                    .city(city)
                    .state(state)
                    .postalCode(postalCode)
                    .customer(customerId)
                    .build();
        } else {
            throw new IllegalArgumentException("Invalid address");
        }
    }

    public static Address createAddress(String streetNumber, String streetName, String city, String state, String postalCode) {
        if (!AddressHelper.isValidStreetNumber(streetNumber)) {
            throw new IllegalArgumentException("Invalid street number");
        }
        if (!AddressHelper.isValidPostalCode(postalCode)) {
            throw new IllegalArgumentException("Invalid postal code");
        }
        if (AddressHelper.isValidStandaloneAddress(streetNumber, streetName, city, state, postalCode)) {
            return Address.builder()
                    .streetNumber(streetNumber)
                    .streetName(streetName)
                    .city(city)
                    .state(state)
                    .postalCode(postalCode)
                    .build();
        } else {
            throw new IllegalArgumentException("Invalid address");
        }
    }

    public static Address createAddress(Long objId, Customer customer) {
        if(objId != null || customer!=null) {
            return  Address.builder()
                    .addressId(objId)
                    .customer(customer)
                    .build();
        }
        else {
            throw new NullPointerException("Address object ID not found");
        }
    }
}