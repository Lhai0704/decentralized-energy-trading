// EnergyTrade.sol
pragma solidity ^0.8.27;

contract EnergyTrade {
    struct Trade {
        address buyer;
        address seller;
        uint256 amount;  // 能源量
        uint256 price;   // 交易价格
    }

    Trade[] public trades;

    // 允许买家和卖家之间创建一笔能源交易
    function createTrade(address _seller, uint256 _amount, uint256 _price) public {
        trades.push(Trade({
            buyer: msg.sender,
            seller: _seller,
            amount: _amount,
            price: _price
        }));
    }

    //查看所有已经记录的交易
    function getTrades() public view returns (Trade[] memory) {
        return trades;
    }
}
