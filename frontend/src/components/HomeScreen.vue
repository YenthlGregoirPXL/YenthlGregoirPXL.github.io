<template>
  <div class="homeScreen">
    <nav-bar></nav-bar>
    <div class="home-screen">
      <!-- Voeg hier de taakbalk (navigation bar) toe -->
      <div class="content">
        <h1 class="title">Welkom bij DartsUitgaves</h1>
        <p class="description">In de applicatie kan je de opbrengsten en de uitgaves van dit dartsseizoen ingeven.</p>
        <router-link to="/speeldagenToevoegen" class="cta-button">Speeldagen Toevoegen</router-link>
        <button class="cta-button" @click="generatePdf">Genereer PDF</button>
      </div>

    </div>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar";
import pdfMake from "pdfmake/build/pdfmake";
import pdfFonts from "pdfmake/build/vfs_fonts";
pdfMake.vfs = pdfFonts.pdfMake.vfs;

export default {
  name: 'HomeScreen',
  components: {NavBar},
  methods: {
    async generatePdf() {
      let uitgaves = [];
      let opbrengsten = [];

      // Fetch Uitgave data
      let response = await fetch("http://localhost:8090/api/Uitgave", {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });
      if (response.ok) {
        uitgaves = await response.json();
      } else {
        console.error("Failed to fetch Uitgave data");
        return;
      }

      // Fetch Speeldagen data
      response = await fetch("http://localhost:8090/api/speeldagen", {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });
      if (response.ok) {
        opbrengsten = await response.json();
      } else {
        console.error("Failed to fetch Speeldagen data");
        return;
      }

      // Calculate total opbrengst, total uitgaves, and remaining amount
      const totalOpbrengst = opbrengsten.reduce((total, item) => total + item.opbrengst, 0);
      const totalUitgaves = uitgaves.reduce((total, item) => total + item.bedrag, 0);
      const remainingAmount = totalOpbrengst - totalUitgaves;

      console.log(opbrengsten);
      const docDefinition = {
        content: [
          { text: "Hello, this is a PDF generated in Vue.js", fontSize: 16 },
          { text: "You can add content dynamically", fontSize: 14, margin: [0, 10] },
          {
            text: "Opbrengsten:",
            fontSize: 14,
            margin: [0, 10],
          },
          {
            table: {
              widths: ["auto", "auto", "auto"], // Define column widths
              body: [
                ["Datum", "Opbrengst", "Tegenstander"],
                ...opbrengsten.map((item) => [
                  item.datum.join("/"),
                  item.opbrengst.toString(),
                  item.tegenstander.naam,
                ]), // Create rows for opbrengsten
              ],
            },
            layout: "lightHorizontalLines", // Add horizontal lines to the table
          },
          {
            text: "Speeldagen:",
            fontSize: 14,
            margin: [0, 10],
          },
          {
            table: {
              widths: ["auto", "auto", "auto"], // Define column widths
              body: [
                ["Datum", "Omschrijving", "Bedrag"],
                ...uitgaves.map((item) => [
                  item.datum.join("/"),
                  item.omschrijving,
                  item.bedrag.toString(),
                ]), // Create rows for uitgaves
              ],
            },
            layout: "lightHorizontalLines", // Add horizontal lines to the table
          },
          {
            text: "Total Opbrengst: " + totalOpbrengst.toFixed(2), // Display total opbrengst
            fontSize: 14,
            margin: [0, 10],
          },
          {
            text: "Total Uitgaves: " + totalUitgaves.toFixed(2), // Display total uitgaves
            fontSize: 14,
            margin: [0, 10],
          },
          {
            text: "Remaining Amount: " + remainingAmount.toFixed(2), // Display remaining amount
            fontSize: 14,
            margin: [0, 10],
          },
        ],
        styles: {
          header: {
            fontSize: 18,
            bold: true,
            alignment: "center",
            margin: [0, 0, 0, 20],
          },
        },
      };
      const pdf = pdfMake.createPdf(docDefinition);

      pdf.download("generated-pdf.pdf");
    },
  },




};
</script>

<style scoped>
.home-screen {
  background-color: #f0f0f0;
  min-height: 95vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-family: Arial, sans-serif;
}

.content {
  margin-top: -100px;
  text-align: center;
  padding: 20px;
}

.title {
  font-size: 36px;
  margin-bottom: 20px;
}

.description {
  font-size: 18px;
  margin-bottom: 30px;
}

.cta-button {
  margin-left: 10px;
  display: inline-block;
  padding: 10px 20px;
  background-color: #007BFF;
  color: #fff;
  text-decoration: none;
  border-radius: 4px;
  font-size: 18px;
  transition: background-color 0.3s;
}

.cta-button:hover {
  background-color: #0056b3;
}
</style>
