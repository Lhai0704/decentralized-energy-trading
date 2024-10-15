// scripts/deploy.js
async function main() {
    const [deployer] = await ethers.getSigners();

    console.log("Deploying contracts with the account:", deployer.address);

    const EnergyTrade = await ethers.getContractFactory("EnergyTrade");
    const energyTrade = await EnergyTrade.deploy();

    console.log("EnergyTrade contract deployed to:", energyTrade.address);
}

main()
  .then(() => process.exit(0))
  .catch((error) => {
    console.error(error);
    process.exit(1);
  });
