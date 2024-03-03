import GreetingBanner from "@/components/GreetingBanner/GreetingBanner";
import NavCategory from "@/components/NavCategory/NavCategory";
import { Showcase } from "@/components/Showcase/Showcase";
import { getCategory } from "@/utils/apiClient";

export default async function Home() {
  const categories = ['vasos', 'afiches', 'stickers', 'juegos', 'muñecos']
    .map(category => getCategory(category))

  const [
    glasses,
    affiches,
    stickers,
    games,
    figures,
  ] = await Promise.all(categories)

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
