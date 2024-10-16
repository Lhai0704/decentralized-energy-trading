// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.27;

contract EnergyTrading {
    struct EnergyListing {
        address seller;
        uint256 amount;
        uint256 price;
        bool active;
    }

    mapping(uint256 => EnergyListing) public listings;
    uint256 public listingCount;

    event EnergyListed(uint256 indexed listingId, address indexed seller, uint256 amount, uint256 price);
    event EnergySold(uint256 indexed listingId, address indexed buyer, address indexed seller, uint256 amount, uint256 price);

    function listEnergy(uint256 _amount, uint256 _price) external {
        listingCount++;
        listings[listingCount] = EnergyListing(msg.sender, _amount, _price, true);
        emit EnergyListed(listingCount, msg.sender, _amount, _price);
    }

    function buyEnergy(uint256 _listingId) external payable {
        EnergyListing storage listing = listings[_listingId];
        require(listing.active, "Listing is not active");
        require(msg.value == listing.price, "Incorrect payment amount");

        listing.active = false;
        payable(listing.seller).transfer(msg.value);

        emit EnergySold(_listingId, msg.sender, listing.seller, listing.amount, listing.price);
    }

    function getListingDetails(uint256 _listingId) external view returns (address, uint256, uint256, bool) {
        EnergyListing storage listing = listings[_listingId];
        return (listing.seller, listing.amount, listing.price, listing.active);
    }
}