import { Kumbh_Sans } from "next/font/google";
import "./globals.css";
import Page from "@/components/Page/Page";
import Header from "@/components/Header/Header";
import { GlobalContextProvider } from "@/context/store";
import SignIn from "@/components/Popup/SignUp/SignUp";

const kumbh = Kumbh_Sans({ subsets: ["latin"], weight: ["400", "700"] });

export const metadata = {
  title: "Create Next App",
  description: "Generated by create next app",
};

export default function RootLayout({ children }) {
  return (
    <html lang="es">
      <body className={kumbh.className}>
        <GlobalContextProvider>
          <Page>
            <Header />
            {children}
          </Page>
          <SignIn />
        </GlobalContextProvider>
      </body>
    </html>
  );
}
