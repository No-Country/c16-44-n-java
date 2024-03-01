"use client"
import GreetingBanner from "@/components/GreetingBanner/GreetingBanner";
import NavCategory from "@/components/NavCategory/NavCategory";
import ProductCard from "@/components/ProductCard/ProductCard";

export default function Home() {
  return <main className="main">
    <GreetingBanner />
    <NavCategory />
    {Array(5).fill(<ProductCard />)}
  </main>
}
