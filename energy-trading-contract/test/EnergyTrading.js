const { expect } = require("chai");
const { ethers } = require("hardhat");
const { loadFixture } = require("@nomicfoundation/hardhat-toolbox/network-helpers");

describe("EnergyTrading", function () {
  async function deployEnergyTradingFixture() {
    const [owner, addr1, addr2] = await ethers.getSigners();

    const EnergyTrading = await ethers.getContractFactory("EnergyTrading");
    const energyTrading = await EnergyTrading.deploy();

    return { energyTrading, owner, addr1, addr2 };
  }

  it("Should list energy for sale", async function () {
    const { energyTrading, addr1 } = await loadFixture(deployEnergyTradingFixture);

    await energyTrading.connect(addr1).listEnergy(100, ethers.parseEther("1"));
    const listing = await energyTrading.getListingDetails(1);

    expect(listing[0]).to.equal(addr1.address);
    expect(listing[1]).to.equal(100);
    expect(listing[2]).to.equal(ethers.parseEther("1"));
    expect(listing[3]).to.be.true;
  });

  it("Should allow buying energy", async function () {
    const { energyTrading, addr1, addr2 } = await loadFixture(deployEnergyTradingFixture);

    await energyTrading.connect(addr1).listEnergy(100, ethers.parseEther("1"));

    await expect(energyTrading.connect(addr2).buyEnergy(1, { value: ethers.parseEther("1") }))
      .to.emit(energyTrading, "EnergySold")
      .withArgs(1, addr2.address, addr1.address, 100, ethers.parseEther("1"));

    const listing = await energyTrading.getListingDetails(1);
    expect(listing[3]).to.be.false;
  });

  // 添加更多测试用例...
});