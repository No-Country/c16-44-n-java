"use client"
import GreetingBanner from "@/components/GreetingBanner/GreetingBanner";
import NavCategory from "@/components/NavCategory/NavCategory";

import { Showcase } from "@/components/Showcase/Showcase";

export default function Home() {
  return <main className="main">
    <GreetingBanner />
    <NavCategory />
    <Showcase name_category={'Figuras'} />
    <Showcase name_category={'Mangas'} />
    <Showcase name_category={'Indumentaria'} />
    <Showcase name_category={'Accesorios'} />


  </main>
}
