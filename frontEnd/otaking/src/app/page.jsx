'use client'
import GreetingBanner from "@/components/GreetingBanner/GreetingBanner";
import NavCategory from "@/components/NavCategory/NavCategory";
import { Showcase } from "@/components/Showcase/Showcase";
import { getCategory } from "@/utils/apiClient";
import { useEffect, useState } from "react";

export default function Home() {
  const [glasses, setGlasses] = useState([]);
  const [affiches, setAffiches] = useState([]);
  const [stickers, setStickers] = useState([]);
  const [games, setGames] = useState([]);
  const [figures, setFigures] = useState([])

  useEffect(() => {
    getCategory('vasos')
      .then(setGlasses)

    getCategory('afiches')
      .then(setAffiches)

    getCategory('stickers')
      .then(setStickers)

    getCategory('juegos')
      .then(setGames)

    getCategory('muñecos')
      .then(setFigures)
  }, [])

  return <main className="main">
    <GreetingBanner />
    <NavCategory />
    <Showcase name_category={'Vasos'} items={glasses} />
    <Showcase name_category={'Afiches'} items={affiches} />
    <Showcase name_category={'Stickers'} items={stickers} />
    <Showcase name_category={'Juegos'} items={games} />
    <Showcase name_category={'Muñecos'} items={figures} />
  </main>
}
