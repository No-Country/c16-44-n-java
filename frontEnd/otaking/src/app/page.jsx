"use client"
import GreetingBanner from "@/components/GreetingBanner/GreetingBanner";
import NavCategory from "@/components/NavCategory/NavCategory";

export default function Home() {
  return <main className="main">
    <GreetingBanner />
    <NavCategory />
  </main>
}
